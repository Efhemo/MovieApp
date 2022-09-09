package com.efhem.moviegalore.data.repository

import kotlinx.coroutines.flow.Flow

interface MovieRepository {

    fun getMovieStream(): Flow<List<Movie>>
}