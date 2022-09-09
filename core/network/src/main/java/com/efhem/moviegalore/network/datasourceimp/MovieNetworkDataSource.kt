package com.efhem.moviegalore.network.datasource

import com.efhem.moviegalore.network.model.NetworkMovieResponse

public interface MovieNetworkDataSource {

    public fun getPopularMovies(page: Int): NetworkMovieResponse

    public fun getTopRatedMovies(page: Int): NetworkMovieResponse

}