package com.efhem.moviegalore.data.repository

import com.efhem.moviegalore.model.Movie
import com.efhem.moviegalore.model.MovieCategory
import kotlinx.coroutines.flow.Flow
import com.efhem.moviegalore.data.model.Result

interface MovieRepository {

    val category : MovieCategory

    fun getMoviesStream(): Flow<List<Movie>>

    fun getMovieStream(id: Int): Flow<Movie>

    fun toggleFavourite(id: Int, isFavourite: Boolean): Int

    fun fetchNextPage(): Flow<Result<Boolean>>
}