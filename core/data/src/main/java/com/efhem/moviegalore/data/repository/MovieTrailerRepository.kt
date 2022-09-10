package com.efhem.moviegalore.data.repository

import com.efhem.moviegalore.data.model.Result
import com.efhem.moviegalore.model.MovieTrailer
import kotlinx.coroutines.flow.Flow

interface MovieTrailerRepository {

    fun fetchTrailer(movieId: Int): Flow<Result<List<MovieTrailer>>>

}