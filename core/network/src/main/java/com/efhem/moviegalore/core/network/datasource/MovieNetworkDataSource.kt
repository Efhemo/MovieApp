package com.efhem.moviegalore.core.network.datasource

import com.efhem.moviegalore.core.network.datasourceimp.MovieNetworkDataSource
import com.efhem.moviegalore.core.network.model.NetworkMovieResponse
import com.efhem.moviegalore.core.network.retrofit.RetrofitNetworkApi
import javax.inject.Inject

internal class MovieNetworkDataSourceImp @Inject constructor (
    private val api: RetrofitNetworkApi,
    private val apiKey: String
) : MovieNetworkDataSource {

    override suspend fun getPopularMovies(page: Int): NetworkMovieResponse {
        return api.getPopularMovies(apiKey, page)
    }

    override suspend fun getTopRatedMovies(page: Int): NetworkMovieResponse {
        return api.getTopRatedMovies(apiKey, page)
    }

}