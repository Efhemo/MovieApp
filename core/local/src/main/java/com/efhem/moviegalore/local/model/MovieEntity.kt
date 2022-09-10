package com.efhem.moviegalore.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.efhem.moviegalore.model.Movie
import com.efhem.moviegalore.model.MovieCategory

@Entity(tableName = "movie")
data class MovieEntity(
    @PrimaryKey
    val id: Int,
    val adult: Boolean,
    val overview: String,
    val releaseDate: String,
    val originalTitle: String,
    val originalLanguage: String,
    val title: String,
    val backdropPath: String,
    val popularity: Double,
    val voteCount: Int,
    val video: Boolean,
    val voteAverage: Double,
    var isFavourite: Boolean = false,
    val category: MovieCategory
)


fun MovieEntity.asExternalModel() = Movie(
    this.id,
    this.adult,
    this.overview,
    this.releaseDate,
    this.originalTitle,
    this.originalLanguage,
    this.title,
    this.backdropPath,
    this.popularity,
    this.voteCount,
    this.video,
    this.voteAverage,
    this.isFavourite,
    this.category
)