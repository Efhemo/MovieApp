package com.efhem.moviegalore.feature.movie.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.efhem.moviegalore.core.data.di.MovieRepositoryPopular
import com.efhem.moviegalore.core.data.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject


@HiltViewModel
class MovieDetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    @MovieRepositoryPopular val popularMovieRepository: MovieRepository,
): ViewModel() {

    private val id: Int = checkNotNull(
        savedStateHandle[MovieDetailsFragment.id]
    )

    val movie = popularMovieRepository.getMovieStream(id).stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5_000),
        initialValue = null
    )



    //Todo : fetch movie review by id
    fun fetchReview(){
        throw NotImplementedError("not implemented")
    }

    //Todo : fetch movie trailer by id
    fun fetchTrailer(){
        throw NotImplementedError("not implemented")
    }

}