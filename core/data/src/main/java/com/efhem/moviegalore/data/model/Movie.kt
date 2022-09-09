package com.efhem.moviegalore.data.model

import com.efhem.moviegalore.local.model.MovieEntity
import com.efhem.moviegalore.model.MovieCategory
import com.efhem.moviegalore.model.MovieReview
import com.efhem.moviegalore.network.model.NetworkMovie
import com.efhem.moviegalore.network.model.NetworkMovieReview

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