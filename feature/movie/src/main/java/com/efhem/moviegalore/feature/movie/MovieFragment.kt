package com.efhem.moviegalore.feature.movie

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.efhem.moviegalore.core.model.Movie
import com.efhem.moviegalore.feature.movie.databinding.FragmentMovieBinding
import com.efhem.moviegalore.feature.movie.detail.MovieDetailsFragment
import com.efhem.moviegalore.feature.movie.utils.onReachBottom
import com.efhem.moviegalore.feature.movie.utils.showSnackbar
import com.efhem.moviegalore.feature.movie.utils.view_binding.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MovieFragment : Fragment(R.layout.fragment_movie) {

    private val binding by viewBinding<FragmentMovieBinding>()

    private val viewModel : MovieViewModel by viewModels()

    private val navController: NavController by lazy {
        findNavController()
    }

    private val popularAdapter by lazy {
        MovieAdapter( MovieClickListener { movie, _ ->
            toDetails(movie)
        })
    }

    private fun toDetails(movie: Movie) {
        findNavController().navigate(
            R.id.action_movieFragment_to_movieDetailsFragment,
            Bundle().apply {
                this.putInt(MovieDetailsFragment.id, movie.id)
            })
    }

    private val topAdapter by lazy {
        MovieAdapter( MovieClickListener { movie, _ ->
            toDetails(movie)
        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observeTopRatedViewState()

        observePopularViewState()

    }

    private fun observeTopRatedViewState(){
        binding.topRatedRc.apply {
            this.adapter = topAdapter
            this.layoutManager = LinearLayoutManager(requireContext()).apply {
                orientation = LinearLayoutManager.HORIZONTAL
            }
            onReachBottom { viewModel.onEvent(NextPageEvent.TopRatedNextPage) }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.topRatedMovies.collect { movies ->
                    topAdapter.submitList(movies)
                }
            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.popularUiState.collect { state ->
                    if(state.isLoading){
                        binding.progressTopRated.visibility = View.VISIBLE
                    } else {
                        binding.progressTopRated.visibility = View.GONE
                    }
                    val msg = state.errorMsg
                    if(msg != null){
                        showSnackbar(msg)
                        viewModel.onEvent(NextPageEvent.IsShownTopRatedError)
                    }
                }
            }
        }
    }

    private fun observePopularViewState() {
        binding.popularRc.apply {
            this.adapter = popularAdapter
            this.layoutManager = LinearLayoutManager(requireContext()).apply {
                orientation = LinearLayoutManager.HORIZONTAL
            }
            onReachBottom { viewModel.onEvent(NextPageEvent.PopularNextPage) }
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
                viewModel.topRatedUiState.collect { state ->
                    if (state.isLoading) {
                        binding.progressTopRated.visibility = View.VISIBLE
                    } else {
                        binding.progressTopRated.visibility = View.GONE
                    }

                    val msg = state.errorMsg
                    if (msg != null) {
                        showSnackbar(msg)
                        viewModel.onEvent(NextPageEvent.IsShownTopRatedError)
                    }
                }
            }
        }
    }

}