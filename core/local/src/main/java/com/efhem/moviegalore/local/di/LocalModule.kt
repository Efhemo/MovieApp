package com.efhem.moviegalore.local.di

import android.content.Context
import com.efhem.moviegalore.local.room.MovieDao
import com.efhem.moviegalore.local.room.MovieGaloreDatabase
import com.efhem.moviegalore.local.storage.Storage
import com.efhem.moviegalore.local.storage.StorageImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@[Module InstallIn(SingletonComponent::class)]
internal object LocalModule {

    @[Provides Singleton]
    fun provideDatabase(@ApplicationContext context: Context): MovieGaloreDatabase {
        return MovieGaloreDatabase.build(context)
    }

    @[Provides Singleton]
    fun provideMovieDao(movieGaloreDatabase: MovieGaloreDatabase): MovieDao {
        return movieGaloreDatabase.movieDao
    }

    @[Provides Singleton]
    fun provideStorage(@ApplicationContext context: Context): Storage {
        return StorageImp(context)
    }
}
