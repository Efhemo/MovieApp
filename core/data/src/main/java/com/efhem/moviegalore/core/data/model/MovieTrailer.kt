package com.efhem.moviegalore.core.data.model

import com.efhem.moviegalore.core.model.MovieTrailer
import com.efhem.moviegalore.core.network.model.NetworkTrailer

fun NetworkTrailer.asExternal() = MovieTrailer(
    this.key, this.name
)