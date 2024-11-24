package com.example.moviedb

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.moviedb.database.Movie
import com.example.moviedb.database.MovieDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieViewModel(application: Application) : AndroidViewModel(application) {

    private val movieDao = MovieDatabase.getDatabase(application).movieDao()
    val allMovies: LiveData<List<Movie>> = movieDao.getAllMovies()

    fun insertMovie(movie: Movie) {
        viewModelScope.launch(Dispatchers.IO) {
            movieDao.insert(movie)
        }
    }
}
