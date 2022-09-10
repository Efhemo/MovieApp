package com.efhem.moviegalore.core.network.datasourceimp

import com.efhem.moviegalore.core.network.model.NetworkMovieReviewResponse

public interface MovieReviewDataSource {

    public suspend fun getReviewResponse(
        id: Int,
    ): NetworkMovieReviewResponse
}