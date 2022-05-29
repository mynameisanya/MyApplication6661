package com.example.myapplication666.ui.modules.interpersonal_effectiveness

import androidx.lifecycle.ViewModel
import com.example.myapplication666.database.DataInterpersonalExercise
import com.example.myapplication666.database.DatabaseDao

class InterpersonalExerciseViewModel(private val dao: DatabaseDao) : ViewModel() {

    fun getExercises(): List<DataInterpersonalExercise> = dao.getAllInterpersonalExercise()

    fun insertExercises(data: DataInterpersonalExercise) {
        dao.insertInterpersonalExercise(data)
    }
}