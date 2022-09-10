package com.efhem.moviegalore.core.data.model

import com.efhem.moviegalore.core.model.MovieReview
import com.efhem.moviegalore.core.network.model.NetworkMovieReview


fun NetworkMovieReview.asExternal() = MovieReview(
    this.author,
    this.content,
    this.id,
    this.url
)