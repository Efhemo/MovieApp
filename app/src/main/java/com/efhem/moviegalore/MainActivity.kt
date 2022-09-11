package com.efhem.moviegalore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.efhem.moviegalore.core.model.Movie
import dagger.hilt.android.AndroidEntryPoint
import com.efhem.moviegalore.core.model.MovieCategory

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {


    private val movie = Movie(
        adult = false,
        overview = "Three friends come",
        releaseDate = "2021-09-11",
        id = 1006851,
        originalTitle = "Superman",
        originalLanguage = "en",
        title = "Superman carton",
        backdropPath = "/bL7VIHQ4Nl0hZMw8ZeX6byoEEZJ.jpg",
        popularity = 1135.086,
        voteCount = 77,
        video = true,
        voteAverage = 5.9,
        isFavourite = true,
        category = MovieCategory.POPULAR
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}