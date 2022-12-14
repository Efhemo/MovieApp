package com.efhem.moviegalore.core.data.repository

import com.efhem.moviegalore.core.data.model.asEntity
import com.efhem.moviegalore.core.local.model.MovieEntity
import com.efhem.moviegalore.core.local.model.asExternalModel
import com.efhem.moviegalore.core.local.room.MovieDao
import com.efhem.moviegalore.core.local.storage.Storage
import com.efhem.moviegalore.core.model.Movie
import com.efhem.moviegalore.core.model.MovieCategory
import com.efhem.moviegalore.core.network.datasourceimp.MovieNetworkDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import com.efhem.moviegalore.core.data.model.Result
import java.lang.RuntimeException

class PopularMovieRepository @Inject constructor(
    private val movieDao: MovieDao,
    private val movieNetworkDataSource: MovieNetworkDataSource,
    private val storage: Storage
) : MovieRepository {

    override val category = MovieCategory.POPULAR

    override fun getMoviesStream(): Flow<List<Movie>> {
        return movieDao.moviesStream(category).map { it.map(MovieEntity::asExternalModel) }
    }

    override fun getMovieStream(id: Int): Flow<Movie> {
        return movieDao.movieStream(id).map { it.asExternalModel() }
    }

    override fun toggleFavourite(id: Int, isFavourite: Boolean): Int =
        movieDao.toggleFavourite(id, isFavourite)


    override fun fetchNextPage(): Flow<Result<Boolean>> {
        return flow {
            emit(Result.Loading)
            runCatching {
                fetchNetPage()
            }.onSuccess {
                emit(Result.Success(it))
            }.onFailure {
                emit(Result.Error(RuntimeException(it.message)))
            }
        }
    }

    private suspend fun fetchNetPage(): Boolean {
        val page = storage.popularCurrentPage() + 1
        val popularMovie = movieNetworkDataSource.getPopularMovies(page)
        movieDao.insertMovie(popularMovie.results.map { it.asEntity(category) })
        storage.insertPopularCurrentPage(popularMovie.page)
        return true
    }
}