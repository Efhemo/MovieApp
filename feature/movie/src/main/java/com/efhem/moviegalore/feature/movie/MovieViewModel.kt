package com.efhem.moviegalore.feature.movie

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.efhem.moviegalore.core.data.di.MovieRepositoryPopular
import com.efhem.moviegalore.core.data.repository.MovieRepository
import com.efhem.moviegalore.core.model.Movie
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MovieViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    @MovieRepositoryPopular val movieRepository: MovieRepository
): ViewModel() {

    val stateFlow = movieRepository.getMoviesStream().stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5_000),
        initialValue = emptyList()
    )

    init {
        fetch()
    }


    private fun fetch(){
        viewModelScope.launch {
            movieRepository.fetchNextPage().collectLatest {  }
        }
    }


    fun onEvent(event: NextPageEvent){
        when (event) {
            is NextPageEvent.popularNextPage -> {

            }
            is NextPageEvent.topRatedNextPage -> {

            }
        }
    }

}


data class MovieUiState(
    val popularMovies: List<Movie>,
    val topRatedMovie: List<Movie>,
    val favourite: List<Movie>
)


sealed interface NextPageEvent {
    object popularNextPage : NextPageEvent
    object topRatedNextPage : NextPageEvent
}