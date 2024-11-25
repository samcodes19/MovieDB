package com.example.moviedb

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moviedb.databinding.ActivityMovieDetailsBinding
import com.example.moviedb.database.Movie

class ActivityMovieDetails : AppCompatActivity() {
    private lateinit var binding: ActivityMovieDetailsBinding
    private val viewModel: MovieViewModel by viewModels()
    private lateinit var adapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovieDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set up RecyclerView Adapter and LayoutManager
        adapter = MovieAdapter { movie -> showMovieDetails(movie) }
        binding.moviesRecyclerView.adapter = adapter
        binding.moviesRecyclerView.layoutManager = LinearLayoutManager(this)

        // Observe all movies and update the adapter when data changes
        viewModel.allMovies.observe(this) { movies ->
            // Update the adapter with the new list of movies
            adapter.submitList(movies)
        }
    }

    // Handle item clicks and pass movie details to the next activity
    private fun showMovieDetails(movie: Movie) {
        val intent = Intent(this, MovieItem::class.java)
        intent.putExtra("movieName", movie.name)
        intent.putExtra("movieTheatre", movie.theatre)
        intent.putExtra("movieCost", movie.cost)
        startActivity(intent)
    }
}
