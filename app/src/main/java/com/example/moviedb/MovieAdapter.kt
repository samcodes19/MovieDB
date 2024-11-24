package com.example.moviedb

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.moviedb.database.Movie
import com.example.moviedb.databinding.ActivityMovieItemBinding // Update this import

class MovieAdapter(private val clickListener: (Movie) -> Unit) :
    ListAdapter<Movie, MovieAdapter.MovieViewHolder>(DiffCallback()) {

    class MovieViewHolder(private val binding: ActivityMovieItemBinding) : // Update binding type
        RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: Movie, clickListener: (Movie) -> Unit) {
            binding.movieNameText.text = movie.name // Bind movie name
            binding.root.setOnClickListener { clickListener(movie) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val binding = ActivityMovieItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        ) // Correctly inflate MovieListItemBinding
        return MovieViewHolder(binding)
    }


    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(getItem(position), clickListener)
    }

    class DiffCallback : DiffUtil.ItemCallback<Movie>() {
        override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean = oldItem == newItem
    }
}