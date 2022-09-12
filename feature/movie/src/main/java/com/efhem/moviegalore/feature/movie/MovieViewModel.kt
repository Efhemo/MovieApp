package com.efhem.moviegalore.feature.movie

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.efhem.moviegalore.core.data.di.MovieRepositoryPopular
import com.efhem.moviegalore.core.data.di.MovieRepositoryTopRated
import com.efhem.moviegalore.core.data.repository.MovieRepository
import com.efhem.moviegalore.core.data.model.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MovieViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    @MovieRepositoryPopular val popularMovieRepository: MovieRepository,
    @MovieRepositoryTopRated val topRatedMovieRepository: MovieRepository
) : ViewModel() {

    val popularMovies = popularMovieRepository.getMoviesStream().stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5_000),
        initialValue = emptyList()
    )

    val topRatedMovies = topRatedMovieRepository.getMoviesStream().stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5_000),
        initialValue = emptyList()
    )

    private val _movieUiStatePopular = MutableStateFlow(MovieUiState(true, null))
    val popularUiState: StateFlow<MovieUiState> = _movieUiStatePopular

    private val _topRatedUiState = MutableStateFlow(MovieUiState(true, null))
    val topRatedUiState: StateFlow<MovieUiState> = _topRatedUiState


    init {
        fetchPopular(true)
        fetchTopRated(true)
    }


    private fun fetchPopular(forceUpdate: Boolean = false) {
        viewModelScope.launch {
            if (_movieUiStatePopular.value.isLoading && !forceUpdate) {
                return@launch
            }
            popularMovieRepository.fetchNextPage().collectLatest {
                _movieUiStatePopular.value = result(it)
            }
        }
    }

    private fun fetchTopRated(forceUpdate: Boolean = false) {
        viewModelScope.launch {
            if (_topRatedUiState.value.isLoading && !forceUpdate) {
                return@launch
            }
            topRatedMovieRepository.fetchNextPage().collectLatest {
                _topRatedUiState.value = result(it)
            }
        }
    }

    private fun result(it: Result<Boolean>): MovieUiState {
        return when (it) {
            is Result.Loading -> MovieUiState(isLoading = true, null)
            is Result.Error ->
                MovieUiState(isLoading = false, it.exception?.message)
            is Result.Success -> MovieUiState(isLoading = false, null)
        }
    }


    fun onEvent(event: NextPageEvent) {
        when (event) {
            is NextPageEvent.PopularNextPage -> {
                fetchPopular()
            }
            is NextPageEvent.TopRatedNextPage -> {
                fetchTopRated()
            }
            is NextPageEvent.IsShownTopRatedError -> _topRatedUiState.value =
                _topRatedUiState.value.copy(errorMsg = null)
            is NextPageEvent.IsShownPopularError -> _movieUiStatePopular.value =
                _movieUiStatePopular.value.copy(errorMsg = null)
        }
    }

}


data class MovieUiState(
    val isLoading: Boolean,
    val errorMsg: String? = null
)


sealed interface NextPageEvent {
    object PopularNextPage : NextPageEvent
    object TopRatedNextPage : NextPageEvent
    object IsShownPopularError : NextPageEvent
    object IsShownTopRatedError : NextPageEvent
}