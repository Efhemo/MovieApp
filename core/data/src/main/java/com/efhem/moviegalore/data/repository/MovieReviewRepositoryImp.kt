package com.efhem.moviegalore.data.repository

import com.efhem.moviegalore.data.model.Result
import com.efhem.moviegalore.data.model.asExternal
import com.efhem.moviegalore.model.MovieReview
import com.efhem.moviegalore.network.datasourceimp.MovieReviewDataSource
import com.efhem.moviegalore.network.model.NetworkMovieReview
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.RuntimeException
import javax.inject.Inject


class MovieReviewRepositoryImp @Inject constructor(
    private val movieReviewDataSource: MovieReviewDataSource
): MovieReviewRepository {

    override fun fetchReview(movieId: Int): Flow<Result<List<MovieReview>>> {
        return flow {
            Result.Loading
            kotlin.runCatching {
                movieReviewDataSource.getReviewResponse(movieId)
            }.onSuccess {
                Result.Success(it.results.map(NetworkMovieReview::asExternal))
            }.onFailure {
                Result.Error(RuntimeException("Fetching fail"))
            }
        }
    }
}