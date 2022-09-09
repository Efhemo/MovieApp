package com.efhem.moviegalore.network.datasourceimp

import com.efhem.moviegalore.network.model.NetworkMovieReviewResponse

public interface MovieReviewRepository {

    public fun getReviewResponse(
        id: Int,
    ): NetworkMovieReviewResponse
}