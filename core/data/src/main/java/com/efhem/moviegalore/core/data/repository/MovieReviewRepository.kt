package com.efhem.moviegalore.core.data.repository

import com.efhem.moviegalore.core.data.model.Result
import com.efhem.moviegalore.core.model.MovieReview
import kotlinx.coroutines.flow.Flow

interface MovieReviewRepository {

    fun fetchReview(movieId: Int): Flow<Result<List<MovieReview>>>

}