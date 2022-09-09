package com.efhem.moviegalore.data.model

import com.efhem.moviegalore.model.MovieReview
import com.efhem.moviegalore.network.model.NetworkMovieReview


fun NetworkMovieReview.asExternal() = MovieReview(
    this.author,
    this.content,
    this.id,
    this.url
)