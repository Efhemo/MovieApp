package com.efhem.moviegalore.network.datasource

import com.efhem.moviegalore.network.model.NetworkTrailerResponse
import com.efhem.moviegalore.network.retrofit.RetrofitNetworkApi
import javax.inject.Inject

public class MovieTrailerDataSourceImp @Inject constructor(
    private val api: RetrofitNetworkApi,
    private val apiKey: String
): MovieTrailerDataSource {

    public override fun getMovieTrailer(
        id: Int,
    ): NetworkTrailerResponse {
        return api.getMovieTrailer(id, apiKey)
    }
}