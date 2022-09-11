package com.efhem.moviegalore.core.network.di

import com.efhem.moviegalore.core.network.datasource.MovieNetworkDataSourceImp
import com.efhem.moviegalore.core.network.datasourceimp.MovieNetworkDataSource
import com.efhem.moviegalore.core.network.retrofit.NetworkApiFactory
import com.efhem.moviegalore.core.network.retrofit.RetrofitNetworkApi
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@[Module InstallIn(SingletonComponent::class)]
internal object NetworkModule {

    val provideMoshi: Moshi
        @[Provides Singleton] get() = Moshi.Builder()
            .add(KotlinJsonAdapterFactory()).build()

    @[Provides Singleton]
    fun provideApiService(moshi: Moshi): RetrofitNetworkApi =
        NetworkApiFactory.createApiService(moshi, true)

    @[Provides Singleton]
    fun provideMovieNetworkDataSource(api: RetrofitNetworkApi): MovieNetworkDataSource =
        MovieNetworkDataSourceImp(api, "95b230b9dc5ca4b835cdb00a1aef6270")
}

