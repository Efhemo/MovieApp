package com.efhem.moviegalore.feature.movie

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.efhem.moviegalore.core.model.Movie
import com.efhem.moviegalore.feature.movie.databinding.MovieItemViewBinding

class MovieAdapter(private val movieClickListener: MovieClickListener) :
    ListAdapter<Movie, MovieAdapter.ItemViewHolder>(DiffCallSingleEnumCandidate()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.movie_item_view, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        with(getItem(position)){
            holder.bind.title.text = title
            holder.bind.rating.rating = voteAverage.toFloat()

            Glide.with(holder.itemView.context).load("https://image.tmdb.org/t/p/w200/$backdropPath")
                .apply(RequestOptions.centerCropTransform())
                .diskCacheStrategy(DiskCacheStrategy.RESOURCE).into(holder.bind.img)

            holder.bind.root.setOnClickListener {
                movieClickListener.onClick(this, position)
            }
        }



        //holder.bind.executePendingBindings()
    }


    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val bind: MovieItemViewBinding = MovieItemViewBinding.bind(itemView)
    }

}

class DiffCallSingleEnumCandidate : DiffUtil.ItemCallback<Movie>() {

    override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
        return oldItem == newItem
    }
}

class MovieClickListener(val clickListener: (singleEnum: Movie, index: Int) -> Unit) {
    fun onClick(singleEnum: Movie, position: Int) = clickListener(singleEnum, position)
}