package com.efhem.moviegalore.core.network.model

import com.squareup.moshi.Json

public data class NetworkMovieResponse(
   var page: Int = 0,
   var results: List<NetworkMovie>,
   var totalResults: Int = 0,
   var totalPages: Int = 0
)

public data class NetworkMovie(
    val adult: Boolean,
    val overview: String,
    @Json(name = "release_date")
    val releaseDate: String,
    val id: Int,
    @Json(name = "original_title")
    val originalTitle: String,
    @Json(name = "original_language")
    val originalLanguage: String,
    val title: String,
    @Json(name = "poster_path")
    val backdropPath: String?,
    val popularity: Double,
    @Json(name = "vote_count")
    val voteCount: Int,
    val video: Boolean,
    @Json(name = "vote_average")
    val voteAverage: Double,
)