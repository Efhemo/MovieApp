package com.efhem.moviegalore.core.model

public data class Movie (
    val id: Int,
    val adult: Boolean,
    val overview: String,
    val releaseDate: String,
    val originalTitle: String,
    val originalLanguage: String,
    val title: String,
    val backdropPath: String?,
    val popularity: Double,
    val voteCount: Int,
    val video: Boolean,
    val voteAverage: Double,
    val isFavourite: Boolean,
    val category: MovieCategory
)