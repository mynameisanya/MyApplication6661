package com.example.myapplication666.ui.diary

import androidx.lifecycle.ViewModel
import com.example.myapplication666.database.App
import com.example.myapplication666.database.DatabaseDao
import com.example.myapplication666.database.Model

class NewDiaryViewModel(private val diaryDao: DatabaseDao): ViewModel() {

    //private val diaryDao = App.returnDatabase.returnDao()
    fun saveData(dataToSave: List<Model>) {
        if (dataToSave.isEmpty()) {
            throw IllegalStateException()
        }
            dataToSave.forEach {
                diaryDao.updateData(it)
            }
    }

    fun getDiaryList(): MutableList<Model> {
        val data = diaryDao.getAll()
        if (data.isEmpty()) {
            return mutableListOf(Model("One", 3), Model("Two", 2), Model("Three", 4))
        }
        return data
    }
}