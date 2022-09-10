package com.efhem.moviegalore.core.network.datasource

import com.efhem.moviegalore.core.network.model.NetworkTrailerResponse

public interface MovieTrailerDataSource {

    public suspend fun getMovieTrailer(
        id: Int,
    ): NetworkTrailerResponse
}