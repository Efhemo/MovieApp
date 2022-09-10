package com.efhem.moviegalore.data.model

import com.efhem.moviegalore.model.MovieCategory
import com.efhem.moviegalore.network.model.NetworkMovie
import com.google.common.truth.Truth.assertThat
import org.junit.Test


class MovieKtTest {

    @Test
    fun `network movie can be mapped to movie entity`(){
        val networkMovie = NetworkMovie(
            adult = false,
            overview = "Three friends come together to defend their valuable mining company from…aliens?! What could possibly go wrong?",
            releaseDate = "2022-08-10",
            id = 1006851,
            originalTitle = "Office Invasion",
            originalLanguage = "en",
            title = "Office Invasion",
            backdropPath = "/bL7VIHQ4Nl0hZMw8ZeX6byoEEZJ.jpg",
            popularity = 1135.086,
            voteCount = 77,
            video = false,
            voteAverage = 5.8
        )

        val entity = networkMovie.asEntity(MovieCategory.TOP_RATED)

        assertThat(entity.adult).isEqualTo(false)
        assertThat(entity.overview).isEqualTo("Three friends come together to defend their valuable mining company from…aliens?! What could possibly go wrong?")
        assertThat(entity.releaseDate).isEqualTo("2022-08-10")
        assertThat(entity.id).isEqualTo(1006851)
        assertThat(entity.originalTitle).isEqualTo("Office Invasion")
        assertThat(entity.originalLanguage).isEqualTo("en")
        assertThat(entity.title).isEqualTo("Office Invasion")
        assertThat(entity.backdropPath).isEqualTo("/bL7VIHQ4Nl0hZMw8ZeX6byoEEZJ.jpg")
        assertThat(entity.popularity).isEqualTo(1135.086)
        assertThat(entity.voteCount).isEqualTo(77)
        assertThat(entity.video).isEqualTo(false)
        assertThat(entity.voteAverage).isEqualTo(5.8)
    }

}