package com.example.myapplication666.ui.modules.interpersonal_effectiveness

import androidx.lifecycle.ViewModel
import com.example.myapplication666.database.DataExercise
import com.example.myapplication666.database.DatabaseDao

    class ExercisesViewModel2(private val dao: DatabaseDao) : ViewModel() {

        fun getExercises():List<DataExercise> = dao.getAllExercise()

        fun insertExercises(data: DataExercise) {
            dao.insertExercise(data)
        }
    }