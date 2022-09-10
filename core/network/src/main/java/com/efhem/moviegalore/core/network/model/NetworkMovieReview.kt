package com.efhem.moviegalore.core.network.model


public data class NetworkMovieReviewResponse(
    val page: Int = 0,
    val results: List<NetworkMovieReview>,
)

public data class NetworkMovieReview(
    val author: String,
    val content: String,
    val id: String,
    val url: String
)
