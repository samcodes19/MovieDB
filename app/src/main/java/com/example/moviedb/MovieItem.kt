package com.example.moviedb

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.moviedb.databinding.ActivityMovieItemBinding

class MovieItem : AppCompatActivity() {
    private lateinit var binding: ActivityMovieItemBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovieItemBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = intent.getStringExtra("movieName")
        val theatre = intent.getStringExtra("movieTheatre")
        val cost = intent.getDoubleExtra("movieCost", 0.0)

        binding.movieNameText.text = name ?: "Unknown Movie"
        binding.movieTheatreText.text = theatre ?: "Unknown Theatre"
        binding.movieCostText.text = String.format("Cost: $%.2f", cost) // Format cost
    }
}