package com.efhem.moviegalore.feature.movie.detail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.efhem.moviegalore.core.model.Movie
import com.efhem.moviegalore.feature.movie.R
import com.efhem.moviegalore.feature.movie.databinding.FragmentMovieDetailsBinding
import com.efhem.moviegalore.feature.movie.utils.view_binding.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class MovieDetailsFragment: Fragment(R.layout.fragment_movie_details) {

    private val binding by viewBinding<FragmentMovieDetailsBinding>()
    private val viewModel: MovieDetailViewModel by viewModels()

    companion object {
        const val id = "movieID"
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.movie.collect { movie ->
                    if (movie != null) {
                        setView(movie)
                    }
                }
            }
        }

    }


    fun setView(movie: Movie){

        binding.apply {
            with(movie){
                content.title.text = title
                content.rating.rating = voteAverage.toFloat()
                content.tvDesc.text = overview
                content.tvYear.text = releaseDate

                Glide.with(requireContext()).load("https://image.tmdb.org/t/p/w200/$backdropPath")
                    .apply(RequestOptions.centerCropTransform())
                    .diskCacheStrategy(DiskCacheStrategy.RESOURCE).into(binding.expandedImage)

            }
        }



    }
}