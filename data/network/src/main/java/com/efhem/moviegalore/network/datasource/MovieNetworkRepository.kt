package com.efhem.moviegalore.network.datasource

import com.efhem.moviegalore.network.model.NetworkMovieResponse
import com.efhem.moviegalore.network.retrofit.RetrofitNetworkApi
import javax.inject.Inject

public class MovieNetworkRepositoryImp @Inject constructor (
    private val api: RetrofitNetworkApi,
    private val apiKey: String
) : MovieNetworkRepository {

    public override fun getPopularMovies(): NetworkMovieResponse {
        return api.getPopularMovies(apiKey)
    }

    public override fun getTopRatedMovies(): NetworkMovieResponse {
        return api.getTopRatedMovies(apiKey)
    }

}