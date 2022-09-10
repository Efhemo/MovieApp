package com.efhem.moviegalore.core.data.model

import com.efhem.moviegalore.core.network.model.NetworkMovieReview
import com.google.common.truth.Truth.assertThat
import org.junit.Test


class MovieReviewKtTest {

    @Test
    fun `network movie review can be mapped to movie external model`() {
        val networkMovieReview = NetworkMovieReview(
            author = "sauceopet",
            content = "With great power",
            id = "61cd6119a097dc001c3dd6b3",
            url = "https://www.themoviedb.org/review/61cd6119a097dc001c3dd6b3"
        )

        val movieReview = networkMovieReview.asExternal()

        assertThat(movieReview.author).isEqualTo("sauceopet")
        assertThat(movieReview.content).isEqualTo("With great power")
        assertThat(movieReview.id).isEqualTo("61cd6119a097dc001c3dd6b3")
        assertThat(movieReview.url).isEqualTo("https://www.themoviedb.org/review/61cd6119a097dc001c3dd6b3")

    }

}