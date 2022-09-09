package com.efhem.moviegalore.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.efhem.moviegalore.local.model.MovieEntity
import com.efhem.moviegalore.model.MovieCategory
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
    suspend fun toggleFavourite(id: Int, isFavourite: Boolean): Flow<List<MovieEntity>>
}