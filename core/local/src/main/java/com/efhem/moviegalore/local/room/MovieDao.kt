package com.efhem.moviegalore.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.efhem.moviegalore.local.model.MovieEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovie(movieEntity: MovieEntity)

    @Query("SELECT * FROM movie")
    fun movies(): Flow<List<MovieEntity>>

    @Query("UPDATE movie SET isFavourite = :isFavourite WHERE id = :id")
    suspend fun toggleFavourite(id: Int, isFavourite: Boolean): Flow<List<MovieEntity>>
}