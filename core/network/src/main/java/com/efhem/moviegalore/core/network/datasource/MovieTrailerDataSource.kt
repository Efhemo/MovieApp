package com.efhem.moviegalore.core.network.datasource

import com.efhem.moviegalore.core.network.model.NetworkTrailerResponse
import com.efhem.moviegalore.core.network.retrofit.RetrofitNetworkApi
import javax.inject.Inject

public class MovieTrailerDataSourceImp @Inject constructor(
    private val api: RetrofitNetworkApi,
    private val apiKey: String
): MovieTrailerDataSource {

    public override suspend fun getMovieTrailer(
        id: Int,
    ): NetworkTrailerResponse {
        return api.getMovieTrailer(id, apiKey)
    }
}