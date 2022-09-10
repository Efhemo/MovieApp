package com.efhem.moviegalore.core.data.repository

import com.efhem.moviegalore.core.data.model.Result
import com.efhem.moviegalore.core.data.model.asExternal
import com.efhem.moviegalore.core.model.MovieTrailer
import com.efhem.moviegalore.core.network.datasource.MovieTrailerDataSource
import com.efhem.moviegalore.core.network.model.NetworkTrailer
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


class MovieTrailerRepositoryImp @Inject constructor(
    private val movieTrailerDataSource: MovieTrailerDataSource
): MovieTrailerRepository {

    override fun fetchTrailer(movieId: Int): Flow<Result<List<MovieTrailer>>> {
        return flow {
            Result.Loading
            kotlin.runCatching {
                movieTrailerDataSource.getMovieTrailer(movieId)
            }.onSuccess {
                Result.Success(it.results.map (NetworkTrailer::asExternal))
            }
        }
    }
}