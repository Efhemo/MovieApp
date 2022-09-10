package com.efhem.moviegalore.data.model

import com.efhem.moviegalore.network.model.NetworkTrailer
import com.google.common.truth.Truth.assertThat
import org.junit.Test

class MovieTrailerKtTest {

    @Test
    fun `network movie trailer can be mapped to movie external model`(){

        val networkMovieTrailer = NetworkTrailer(
            key = "XEkeZhWbW7U",
            name = "Monster House - Trailer"
        )
        val movieTrailer = networkMovieTrailer.asExternal()

        assertThat(movieTrailer.key).isNotEmpty()
        assertThat(movieTrailer.key).isEqualTo("XEkeZhWbW7U")
        assertThat(movieTrailer.name).isEqualTo("Monster House - Trailer")

    }

}