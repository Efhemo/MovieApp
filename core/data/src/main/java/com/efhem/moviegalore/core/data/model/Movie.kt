package com.efhem.moviegalore.core.data.model

import com.efhem.moviegalore.core.local.model.MovieEntity
import com.efhem.moviegalore.core.model.MovieCategory
import com.efhem.moviegalore.core.network.model.NetworkMovie

fun NetworkMovie.asEntity(movieCategory: MovieCategory) = MovieEntity(
    this.id,
    this.adult,
    this.overview,
    this.releaseDate,
    this.originalTitle,
    this.originalLanguage,
    this.title,
    this.backdropPath,
    this.popularity,
    this.voteCount,
    this.video,
    this.voteAverage,
    category = movieCategory
)