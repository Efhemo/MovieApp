package com.efhem.moviegalore.feature.movie

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.efhem.moviegalore.feature.movie.databinding.FragmentMovieBinding
import com.efhem.moviegalore.feature.movie.utils.view_binding.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MovieFragment : Fragment(R.layout.fragment_movie) {

    private val binding by viewBinding<FragmentMovieBinding>()

    private val viewModel : MovieViewModel by viewModels()

    val popularAdapter by lazy {
        MovieAdapter( MovieClickListener { movie, position ->

        })
    }

    val topAdapter by lazy {
        MovieAdapter( MovieClickListener { movie, position ->

        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupView()
    }

    private fun setupView(){

        binding.popularRc.apply {
            this.adapter = popularAdapter
            this.layoutManager = LinearLayoutManager(requireContext()).apply {
                orientation = LinearLayoutManager.HORIZONTAL
            }
        }
        binding.topRatedRc.apply {
            this.adapter = topAdapter
            this.layoutManager = LinearLayoutManager(requireContext()).apply {
                orientation = LinearLayoutManager.HORIZONTAL
            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.popularMovies.collect { movies ->
                    popularAdapter.submitList(movies)
                }
            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.topRatedMovies.collect { movies ->
                    topAdapter.submitList(movies)
                }
            }
        }

    }

}