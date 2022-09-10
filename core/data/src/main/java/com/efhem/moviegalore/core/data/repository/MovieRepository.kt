package com.efhem.moviegalore.core.data.repository

import com.efhem.moviegalore.core.model.Movie
import com.efhem.moviegalore.core.model.MovieCategory
import kotlinx.coroutines.flow.Flow
import com.efhem.moviegalore.core.data.model.Result

interface MovieRepository {

    val category : MovieCategory

    fun getMoviesStream(): Flow<List<Movie>>

    fun getMovieStream(id: Int): Flow<Movie>

    fun toggleFavourite(id: Int, isFavourite: Boolean): Int

    fun fetchNextPage(): Flow<Result<Boolean>>
}