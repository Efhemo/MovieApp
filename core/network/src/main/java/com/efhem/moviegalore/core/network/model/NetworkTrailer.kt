package com.efhem.moviegalore.core.network.model;

public data class NetworkTrailerResponse(
    val id: Int,
    val results: List<NetworkTrailer>
)

public data class NetworkTrailer(
    val key: String,
    val name: String
)