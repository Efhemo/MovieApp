package com.efhem.moviegalore.core.data.testdoubles

import com.efhem.moviegalore.core.local.model.MovieEntity
import com.efhem.moviegalore.core.local.room.MovieDao
import com.efhem.moviegalore.core.model.MovieCategory
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

class TestMovieDao : MovieDao {


    private var entitiesStateFlow = MutableStateFlow(
        listOf(
            MovieEntity(
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
                voteAverage = 5.8,
                category = MovieCategory.POPULAR
            )
        )
    )

    override suspend fun insertMovie(movies: List<MovieEntity>) {
        entitiesStateFlow.value = movies
    }

    override fun moviesStream(movieCategory: MovieCategory): Flow<List<MovieEntity>> =
        entitiesStateFlow

    override fun movieStream(id: Int): Flow<MovieEntity> {
        throw NotImplementedError("Unused in tests")
    }

    override fun toggleFavourite(id: Int, isFavourite: Boolean): Int {
        entitiesStateFlow.value.find { it.id == id }.apply {
            this?.isFavourite = isFavourite
        }
        return 1
    }

}