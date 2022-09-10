package com.efhem.moviegalore.core.network.retrofit

import com.efhem.moviegalore.core.network.interceptor.NoInternetInterceptor
import com.efhem.moviegalore.core.network.interceptor.HttpsInterceptor
import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit


public object NetworkApiFactory {

    private const val BASE_URL: String = "http://api.themoviedb.org/3/movie/"

    public fun createApiService(moshi: Moshi, isDebug: Boolean): RetrofitNetworkApi {
        val okHttpClient: OkHttpClient = makeOkHttpClient(
            makeLoggingInterceptor(isDebug)
        )
        return makeApiService(okHttpClient, moshi)
    }

    private fun makeApiService(okHttpClient: OkHttpClient, moshi: Moshi): RetrofitNetworkApi {
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
        return retrofit.create(RetrofitNetworkApi::class.java)
    }

    private fun makeOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(HttpsInterceptor)
            .addInterceptor(NoInternetInterceptor)
            .addInterceptor(httpLoggingInterceptor)
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .build()
    }

    private fun makeLoggingInterceptor(isDebug: Boolean): HttpLoggingInterceptor {
        val logging = HttpLoggingInterceptor()
        logging.level = if (isDebug) {
            HttpLoggingInterceptor.Level.BODY
        } else {
            HttpLoggingInterceptor.Level.NONE
        }
        return logging
    }
}