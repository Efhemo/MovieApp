package com.efhem.moviegalore.network.retrofit

import com.efhem.moviegalore.network.model.NetworkMovieResponse
import com.efhem.moviegalore.network.model.NetworkMovieReviewResponse
import com.efhem.moviegalore.network.model.NetworkTrailerResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


public interface RetrofitNetworkApi {
    @GET("movie/popular")
    public fun getPopularMovies(@Query("api_key") apiKey: String?): NetworkMovieResponse

    @GET("movie/top_rated")
    public fun getTopRatedMovies(@Query("api_key") apiKey: String?): NetworkMovieResponse

    @GET("movie/{movie_id}/videos")
    public fun getMovieTrailer(
        @Path("movie_id") id: Int,
        @Query("api_key") apiKey: String?
    ): NetworkTrailerResponse

    @GET("movie/{movie_id}/reviews")
    public fun getReviewResponse(
        @Path("movie_id") id: Int,
        @Query("api_key") apiKey: String?
    ): NetworkMovieReviewResponse
}