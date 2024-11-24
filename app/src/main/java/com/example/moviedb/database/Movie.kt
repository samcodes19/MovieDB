package com.example.moviedb.database

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "movie_table")
data class Movie(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val theatre: String,
    val cost: Double
)

