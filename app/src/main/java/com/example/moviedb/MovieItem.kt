package com.example.moviedb

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.moviedb.databinding.ActivityMovieItemBinding

class MovieItem : AppCompatActivity() {
    private lateinit var binding: ActivityMovieItemBinding
    private val viewModel: MovieViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovieItemBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val movieId = intent.getIntExtra("movieId", -1)

        if (movieId != -1) {
            viewModel.getMovieById(movieId).observe(this) { movie ->
                if (movie != null) {
                    binding.movieNameText.text = movie.name
                    binding.movieTheatreText.text = movie.theatre
                    binding.movieCostText.text = String.format("Cost: $%.2f", movie.cost)
                }
            }
        }
    }
}

