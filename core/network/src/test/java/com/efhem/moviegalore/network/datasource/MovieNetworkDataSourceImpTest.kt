package com.efhem.moviegalore.network.datasource

import com.efhem.moviegalore.network.datasourceimp.MovieNetworkDataSource
import com.efhem.moviegalore.network.utils.RequestDispatcher
import com.efhem.moviegalore.network.utils.makeTestApiService
import okhttp3.mockwebserver.MockWebServer
import org.junit.Assert.*
import org.junit.Before

public class MovieNetworkDataSourceImpTest {

    private lateinit var mockWebServer: MockWebServer
    private lateinit var movieNetworkDataSource: MovieNetworkDataSource

    @Before
    public fun setUp() {
        mockWebServer = MockWebServer()
        mockWebServer.dispatcher = RequestDispatcher()
        mockWebServer.start()
        movieNetworkDataSource =
            MovieNetworkDataSourceImp(makeTestApiService(mockWebServer),  "")
    }
}