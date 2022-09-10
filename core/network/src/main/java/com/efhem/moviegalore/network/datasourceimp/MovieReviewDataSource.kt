package com.efhem.moviegalore.network.datasourceimp

import com.efhem.moviegalore.network.model.NetworkMovieReviewResponse

public interface MovieReviewDataSource {

    public suspend fun getReviewResponse(
        id: Int,
    ): NetworkMovieReviewResponse
}