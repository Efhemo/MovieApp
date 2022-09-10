package com.efhem.moviegalore.data.di

import com.efhem.moviegalore.data.repository.MovieRepository
import com.efhem.moviegalore.data.repository.PopularMovieRepository
import com.efhem.moviegalore.data.repository.TopRatedMovieRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@[Module InstallIn(SingletonComponent::class)]
interface DataModule {

    @Binds
    fun bindTopRatedMovie(
        topRatedMovieRepository: TopRatedMovieRepository
    ) : MovieRepository

    @Binds
    fun bindPopularMovie(
        popularMovieRepository: PopularMovieRepository
    ) : MovieRepository

}