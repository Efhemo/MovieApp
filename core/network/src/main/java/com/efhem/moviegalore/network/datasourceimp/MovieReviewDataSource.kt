package com.efhem.moviegalore.network.datasourceimp

import com.efhem.moviegalore.network.model.NetworkMovieReviewResponse

public interface MovieReviewDataSource {

    public fun getReviewResponse(
        id: Int,
    ): NetworkMovieReviewResponse
}