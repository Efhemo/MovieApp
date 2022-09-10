package com.efhem.moviegalore.core.data.repository

import com.efhem.moviegalore.core.data.model.Result
import com.efhem.moviegalore.core.model.MovieTrailer
import kotlinx.coroutines.flow.Flow

interface MovieTrailerRepository {

    fun fetchTrailer(movieId: Int): Flow<Result<List<MovieTrailer>>>

}