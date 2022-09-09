package com.efhem.moviegalore.data.repository

import com.efhem.moviegalore.data.model.asEntity
import com.efhem.moviegalore.local.model.MovieEntity
import com.efhem.moviegalore.local.model.asExternalModel
import com.efhem.moviegalore.local.room.MovieDao
import com.efhem.moviegalore.local.storage.Storage
import com.efhem.moviegalore.model.Movie
import com.efhem.moviegalore.model.MovieCategory
import com.efhem.moviegalore.network.datasource.MovieNetworkDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class PopularMovieRepository @Inject constructor (
    private val movieDao: MovieDao,
    private val movieNetworkRepository: MovieNetworkDataSource,
    private val storage: Storage
): MovieRepository {

    override val category = MovieCategory.POPULAR

    override fun getMoviesStream(): Flow<List<Movie>> {
        return movieDao.moviesStream(category).map { it.map(MovieEntity::asExternalModel) }
    }

    override fun getMovieStream(id: Int): Flow<Movie> {
        return movieDao.movieStream(id).map { it.asExternalModel() }
    }


    suspend fun fetchNext() {
        val page = storage.popularCurrentPage() + 1
        val popularMovie = movieNetworkRepository.getPopularMovies(page)
        movieDao.insertMovie(popularMovie.results.map { it.asEntity(category) } )
        storage.insertPopularCurrentPage(popularMovie.page)
    }
}