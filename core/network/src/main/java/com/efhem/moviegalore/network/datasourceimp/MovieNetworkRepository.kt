package com.efhem.moviegalore.network.datasource

import com.efhem.moviegalore.network.model.NetworkMovieResponse

public interface MovieNetworkRepository {

    public fun getPopularMovies(): NetworkMovieResponse

    public fun getTopRatedMovies(): NetworkMovieResponse

}