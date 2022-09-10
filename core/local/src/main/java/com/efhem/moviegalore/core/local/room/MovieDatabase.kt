package com.efhem.moviegalore.core.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
//import com.efhem.moviegalore.core.local.BuildConfig

import com.efhem.moviegalore.core.local.model.MovieEntity

@Database(
    entities = [MovieEntity::class],
    version = 1,
    exportSchema = false
)
abstract class MovieGaloreDatabase : RoomDatabase() {

    abstract val movieDao: MovieDao


    companion object {
        private const val DATABASE_NAME: String = "movie_galore_db"
        fun build(context: Context): MovieGaloreDatabase = Room.databaseBuilder(
            context.applicationContext,
            MovieGaloreDatabase::class.java,
            DATABASE_NAME
        ).fallbackToDestructiveMigration().build()
    }
}
