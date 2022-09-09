package com.efhem.moviegalore.network.datasource

import com.efhem.moviegalore.network.datasourceimp.MovieReviewRepository
import com.efhem.moviegalore.network.model.NetworkMovieReviewResponse
import com.efhem.moviegalore.network.retrofit.RetrofitNetworkApi
import javax.inject.Inject

public class MovieReviewRepositoryImp @Inject constructor(
    private val api: RetrofitNetworkApi,
    private val apiKey: String
): MovieReviewRepository {

    public override fun getReviewResponse(
        id: Int,
    ): NetworkMovieReviewResponse {
        return api.getReviewResponse(id, apiKey)
    }
}