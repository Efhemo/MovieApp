package com.efhem.moviegalore.network.datasource

import com.efhem.moviegalore.network.datasourceimp.MovieNetworkDataSource
import com.efhem.moviegalore.network.model.NetworkMovieResponse
import com.efhem.moviegalore.network.retrofit.RetrofitNetworkApi
import javax.inject.Inject

public class MovieNetworkDataSourceImp @Inject constructor (
    private val api: RetrofitNetworkApi,
    private val apiKey: String
) : MovieNetworkDataSource {

    public override fun getPopularMovies(page: Int): NetworkMovieResponse {
        return api.getPopularMovies(apiKey, page)
    }

    public override fun getTopRatedMovies(page: Int): NetworkMovieResponse {
        return api.getTopRatedMovies(apiKey, page)
    }

}