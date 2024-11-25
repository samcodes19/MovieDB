package com.example.moviedb

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.moviedb.databinding.ActivityMovieItemBinding
import com.example.moviedb.database.Movie

class MovieAdapter(private val onClick: (Movie) -> Unit) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    private var movies: List<Movie> = listOf() // Initialize as an empty list

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val binding = ActivityMovieItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movies[position]
        holder.bind(movie)
    }

    override fun getItemCount(): Int = movies.size

    // This function updates the list of movies in the adapter
    fun submitList(newMovies: List<Movie>) {
        movies = newMovies
        notifyDataSetChanged() // Notify the adapter that the data set has changed
    }

    inner class MovieViewHolder(private val binding: ActivityMovieItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: Movie) {
            // Bind only the movie name to the TextView
            binding.movieNameText.text = movie.name

            // Set click listener to pass movie data to MovieItem activity
            binding.root.setOnClickListener {
                onClick(movie)
            }
        }
    }
}
