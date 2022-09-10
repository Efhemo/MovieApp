package com.efhem.moviegalore.core.data.repository

import com.efhem.moviegalore.core.data.testdoubles.TestMovieDao
import com.efhem.moviegalore.core.data.testdoubles.TestMovieNetworkDataSource
import com.efhem.moviegalore.core.data.testdoubles.TestStorage
import com.efhem.moviegalore.core.local.model.MovieEntity
import com.efhem.moviegalore.core.local.model.asExternalModel
import com.efhem.moviegalore.core.local.room.MovieDao
import com.efhem.moviegalore.core.local.storage.Storage
import com.efhem.moviegalore.core.model.MovieCategory
import com.efhem.moviegalore.core.network.datasourceimp.MovieNetworkDataSource
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.flow.toList
import org.junit.Before
import org.junit.Test


class PopularMovieRepositoryTest {

    private lateinit var subject: PopularMovieRepository

    private lateinit var storage: Storage
    private lateinit var movieDao: MovieDao
    private lateinit var networkDataSource: MovieNetworkDataSource


    @Before
    fun setUp() {
        storage = TestStorage()
        movieDao = TestMovieDao()
        networkDataSource = TestMovieNetworkDataSource()

        subject = PopularMovieRepository(
            storage = storage,
            movieDao = movieDao,
            movieNetworkDataSource = networkDataSource
        )
    }

    @Test
    fun `movie stream is backed by movie dao`() =
        runTest {
            assertThat(
                subject.getMoviesStream().first()
            ).isEqualTo(
                movieDao.moviesStream(MovieCategory.POPULAR).first()
                    .map(MovieEntity::asExternalModel)
            )
        }


    @Test
    fun `check that isFavourite was toggled`() = runTest {

        //when
        subject.toggleFavourite(1006851, true)

        val firstMovie = subject.getMoviesStream().first().first()
        assertThat(firstMovie.isFavourite).isEqualTo(true)
    }

    @Test
    fun `check that network movie was saved in dao`() = runTest {

        val networkPopularMovies = networkDataSource.getPopularMovies(1).results.first()

        //when
        subject.fetchNextPage().take(2).toList()

        val movie = movieDao.moviesStream(MovieCategory.POPULAR).first().first()

        assertThat(networkPopularMovies.title).isEqualTo(movie.title)

    }

}