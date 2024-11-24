package com.example.moviedb.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface MovieDao {

    @Insert
    suspend fun insert(movie: Movie)

    @Query("SELECT * FROM movie_table")
    fun getAllMovies(): LiveData<List<Movie>>
}
