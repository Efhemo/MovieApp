package com.efhem.moviegalore.core.network.datasource

import com.efhem.moviegalore.core.network.datasourceimp.MovieReviewDataSource
import com.efhem.moviegalore.core.network.model.NetworkMovieReviewResponse
import com.efhem.moviegalore.core.network.retrofit.RetrofitNetworkApi
import javax.inject.Inject

public class MovieReviewDataSourceImp @Inject constructor(
    private val api: RetrofitNetworkApi,
    private val apiKey: String
): MovieReviewDataSource {

    public override suspend fun getReviewResponse(
        id: Int,
    ): NetworkMovieReviewResponse {
        return api.getReviewResponse(id, apiKey)
    }
}