package com.example.myapplication666.ui.diary

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication666.database.DatabaseDao
import com.example.myapplication666.database.Model

class DiaryViewModel (private val diaryDao: DatabaseDao): ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is diary Fragment"
    }
    val text: LiveData<String> = _text

    fun getDiaryList(): MutableList<Model> {
        val data = diaryDao.getAll()
        return data
    }
}