package com.efhem.moviegalore.data.repository

import com.efhem.moviegalore.model.Movie
import com.efhem.moviegalore.model.MovieCategory
import kotlinx.coroutines.flow.Flow

interface MovieRepository {

    fun getMoviesStream(): Flow<List<Movie>>

    fun getMovieStream(id: Int): Flow<Movie>

    val category : MovieCategory
}