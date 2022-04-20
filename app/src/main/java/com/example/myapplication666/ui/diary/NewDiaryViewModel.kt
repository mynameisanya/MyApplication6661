package com.example.myapplication666.ui.diary

import androidx.lifecycle.ViewModel
import com.example.myapplication666.database.DatabaseDao
import com.example.myapplication666.database.Model

class NewDiaryViewModel(private val diaryDao: DatabaseDao) : ViewModel() {

    fun insertData(model: Model) {
        diaryDao.insert(model)
    }

    fun saveData(dataToSave: List<Model>) {
        if (dataToSave.isEmpty()) {
            throw IllegalStateException()
        }

        dataToSave.forEach {
            diaryDao.insert(it)
        }
    }

    fun getDefaultDiaryList(): MutableList<Model> {
        return mutableListOf(Model("One", 0), Model("Two", 0), Model("Three", 0))
    }
}