package com.efhem.moviegalore.network.datasource

import com.efhem.moviegalore.network.model.NetworkTrailerResponse

public interface MovieTrailerDataSource {

    public fun getMovieTrailer(
        id: Int,
    ): NetworkTrailerResponse
}