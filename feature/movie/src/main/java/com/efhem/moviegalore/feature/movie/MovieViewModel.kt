package com.efhem.moviegalore.feature.movie

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.efhem.moviegalore.core.data.di.MovieRepositoryPopular
import com.efhem.moviegalore.core.data.repository.MovieRepository
import com.efhem.moviegalore.core.model.Movie
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class MovieViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    @MovieRepositoryPopular movieRepository: MovieRepository
): ViewModel() {


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