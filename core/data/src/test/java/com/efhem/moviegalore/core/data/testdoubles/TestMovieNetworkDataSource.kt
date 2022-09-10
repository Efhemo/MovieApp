package com.efhem.moviegalore.core.data.testdoubles

import com.efhem.moviegalore.core.network.datasourceimp.MovieNetworkDataSource
import com.efhem.moviegalore.core.network.model.NetworkMovie
import com.efhem.moviegalore.core.network.model.NetworkMovieResponse

class TestMovieNetworkDataSource : MovieNetworkDataSource {

    private val response  = NetworkMovieResponse(
        page = 1,
        results = listOf(
            NetworkMovie(
                adult = false,
                overview = "Three friends come",
                releaseDate = "2021-09-11",
                id = 1006851,
                originalTitle = "Superman",
                originalLanguage = "en",
                title = "Superman carton",
                backdropPath = "/bL7VIHQ4Nl0hZMw8ZeX6byoEEZJ.jpg",
                popularity = 1135.086,
                voteCount = 77,
                video = true,
                voteAverage = 5.9
            )
        ),
        totalPages = 123424,
        totalResults = 1341232
    )

    override suspend fun getPopularMovies(page: Int): NetworkMovieResponse = response

    override suspend fun getTopRatedMovies(page: Int): NetworkMovieResponse = response


}