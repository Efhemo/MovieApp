package com.efhem.moviegalore.core.network.datasource

import com.efhem.moviegalore.core.network.datasourceimp.MovieNetworkDataSource
import com.efhem.moviegalore.core.network.utils.RequestDispatcher
import com.efhem.moviegalore.core.network.utils.makeTestApiService
import kotlinx.coroutines.test.TestResult
import kotlinx.coroutines.test.runTest
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Test

public class MovieNetworkDataSourceImpTest {

    private lateinit var mockWebServer: MockWebServer
    private lateinit var movieNetworkDataSource: MovieNetworkDataSource

    @Before
    public fun setUp() {
        mockWebServer = MockWebServer()
        mockWebServer.dispatcher = RequestDispatcher()
        mockWebServer.start()
        movieNetworkDataSource =
            MovieNetworkDataSourceImp(makeTestApiService(mockWebServer),  "23242")
    }

    @After
    public fun tearDown() {
        mockWebServer.shutdown()
    }

    @Test
    public fun `check that getPopularMovies returns data`(): TestResult = runTest {
        val movies = movieNetworkDataSource.getPopularMovies(1)
        assertThat(movies).isNotNull()
        assertThat(movies.results.first().title).isEqualTo("Van Helsing")
    }

    @Test
    public fun `check that getTopRatedMovies returns data`(): TestResult = runTest {
        val movies = movieNetworkDataSource.getTopRatedMovies(1)
        assertThat(movies).isNotNull()
        assertThat(movies.results.first().title).isEqualTo("Van Helsing")
    }
}