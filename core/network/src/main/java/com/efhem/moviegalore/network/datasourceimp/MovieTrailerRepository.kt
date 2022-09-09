package com.efhem.moviegalore.network.datasource

import com.efhem.moviegalore.network.model.NetworkTrailerResponse

public interface MovieTrailerRepository {

    public fun getMovieTrailer(
        id: Int,
    ): NetworkTrailerResponse
}