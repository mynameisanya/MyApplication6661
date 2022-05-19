package com.example.myapplication666.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class DataExercise(@PrimaryKey val date: String, val value: List<Pair<String, String>>)



