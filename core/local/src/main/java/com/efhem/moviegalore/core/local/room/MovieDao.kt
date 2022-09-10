package com.efhem.moviegalore.core.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.efhem.moviegalore.core.local.model.MovieEntity
import com.efhem.moviegalore.core.model.MovieCategory
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovie(movies: List<MovieEntity>)

    @Query("SELECT * FROM movie WHERE category = :movieCategory")
    fun moviesStream(movieCategory: MovieCategory): Flow<List<MovieEntity>>

    @Query("SELECT * FROM movie WHERE id = :id")
    fun movieStream(id: Int): Flow<MovieEntity>

    @Query("UPDATE movie SET isFavourite = :isFavourite WHERE id = :id")
    fun toggleFavourite(id: Int, isFavourite: Boolean): Int
}