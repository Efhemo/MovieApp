package com.efhem.moviegalore.core.network.datasourceimp

import com.efhem.moviegalore.core.network.model.NetworkMovieResponse

public interface MovieNetworkDataSource {

    public suspend fun getPopularMovies(page: Int): NetworkMovieResponse

    public suspend fun getTopRatedMovies(page: Int): NetworkMovieResponse

}