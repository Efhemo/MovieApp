package com.efhem.moviegalore.network.datasource

import com.efhem.moviegalore.network.model.NetworkTrailerResponse

public interface MovieTrailerDataSource {

    public suspend fun getMovieTrailer(
        id: Int,
    ): NetworkTrailerResponse
}