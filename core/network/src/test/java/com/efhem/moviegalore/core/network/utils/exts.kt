package com.efhem.moviegalore.core.network.utils


import com.efhem.moviegalore.core.network.model.NetworkMovieResponse
import com.efhem.moviegalore.core.network.retrofit.RetrofitNetworkApi
import com.google.common.io.Resources
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.mockwebserver.MockWebServer
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.io.File
import java.lang.reflect.ParameterizedType
import java.net.URL

internal const val POPULAR_MOVIE_PATH: String = "/movie/popular?api_key=23242&page=1"
internal const val TOP_RATED_MOVIE_PATH: String = "/movie/top_rated?api_key=23242&page=1"

private val okHttpClient: OkHttpClient
    get() = OkHttpClient.Builder().build()

private val moshi: Moshi
    get() = Moshi.Builder()
        .add(KotlinJsonAdapterFactory()).build()

internal val adapter: JsonAdapter<NetworkMovieResponse>
    get() {
        val type: ParameterizedType = Types.newParameterizedType(
            NetworkMovieResponse::class.java,
            String::class.java
        )
        return moshi.adapter(type)
    }

@Suppress("UnstableApiUsage")
internal fun getJson(path: String): String {
    val uri: URL = Resources.getResource(path)
    val file = File(uri.path)
    return String(file.readBytes())
}

internal fun makeTestApiService(mockWebServer: MockWebServer): RetrofitNetworkApi = Retrofit.Builder()
    .baseUrl(mockWebServer.url("/"))
    .client(okHttpClient)
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .build()
    .create(RetrofitNetworkApi::class.java)