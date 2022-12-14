package com.efhem.moviegalore.core.data.repository

import com.efhem.moviegalore.core.data.model.Result
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
import java.lang.RuntimeException
import javax.inject.Inject

class TopRatedMovieRepository @Inject constructor (
    private val movieDao: MovieDao,
    private val movieNetworkRepository: MovieNetworkDataSource,
    private val storage: Storage,
): MovieRepository {

    override val category: MovieCategory = MovieCategory.TOP_RATED


    override fun getMoviesStream(): Flow<List<Movie>> {
        return movieDao.moviesStream(category).map { it.map(MovieEntity::asExternalModel) }
    }

    override fun getMovieStream(id: Int): Flow<Movie> {
        return movieDao.movieStream(id).map { it.asExternalModel() }
    }

    override fun toggleFavourite(id: Int, isFavourite: Boolean): Int = movieDao.toggleFavourite(id, isFavourite)

    override fun fetchNextPage(): Flow<Result<Boolean>> {
        return flow {
            Result.Loading
            runCatching {
                fetchNetPage()
            }.onSuccess {
                Result.Success(it)
            }.onFailure {
                Result.Error(RuntimeException(it.message))
            }
        }
    }

    private suspend fun fetchNetPage() {
        val page = storage.topRatedCurrentPage() + 1
        val topRatedRepo = movieNetworkRepository.getTopRatedMovies(page)
        movieDao.insertMovie(topRatedRepo.results.map { it.asEntity(category) })
        storage.insertTopRatedPage(topRatedRepo.page)
    }
}