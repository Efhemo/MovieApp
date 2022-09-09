package com.efhem.moviegalore.data.model

import com.efhem.moviegalore.model.MovieTrailer
import com.efhem.moviegalore.network.model.NetworkTrailer

fun NetworkTrailer.asExternal() = MovieTrailer(
    this.key, this.name
)