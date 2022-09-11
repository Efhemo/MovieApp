package com.efhem.moviegalore.core.data.di

import com.efhem.moviegalore.core.data.repository.MovieRepository
import com.efhem.moviegalore.core.data.repository.PopularMovieRepository
import com.efhem.moviegalore.core.data.repository.TopRatedMovieRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Qualifier
import javax.inject.Singleton

@[Module InstallIn(SingletonComponent::class)]
interface DataModule {

    @Binds
    @MovieRepositoryPopular
    fun bindPopularMovie(
        popularMovieRepository: PopularMovieRepository
    ) : MovieRepository

    @Binds
    @MovieRepositoryTopRated
    fun bindTopRatedMovie(
        topRatedMovieRepository: TopRatedMovieRepository
    ) : MovieRepository

}


@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class MovieRepositoryPopular

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class MovieRepositoryTopRated