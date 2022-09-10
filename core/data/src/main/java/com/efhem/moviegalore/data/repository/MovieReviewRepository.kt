package com.efhem.moviegalore.data.repository

import com.efhem.moviegalore.data.model.Result
import com.efhem.moviegalore.model.MovieReview
import kotlinx.coroutines.flow.Flow

interface MovieReviewRepository {

    fun fetchReview(movieId: Int): Flow<Result<List<MovieReview>>>

}