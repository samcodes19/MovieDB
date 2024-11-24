package com.example.moviedb

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.moviedb.database.Movie
import com.example.moviedb.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MovieViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.submitButton.setOnClickListener {
            val name = binding.movieName.text.toString()
            val theatre = binding.movieTheatre.text.toString()
            val cost = binding.movieCost.text.toString().toDoubleOrNull() ?: 0.0

            if (name.isNotBlank() && theatre.isNotBlank() && cost > 0) {
                val movie = Movie(name = name, theatre = theatre, cost = cost)
                viewModel.insertMovie(movie)
                Toast.makeText(this, "Movie Added", Toast.LENGTH_SHORT).show()

                binding.movieName.text.clear()
                binding.movieTheatre.text.clear()
                binding.movieCost.text.clear()
            }
        }

        binding.viewDetailsButton.setOnClickListener {
            startActivity(Intent(this, ActivityMovieDetails::class.java))
        }
    }
}