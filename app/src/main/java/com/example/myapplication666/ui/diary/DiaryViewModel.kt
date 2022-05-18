package com.example.myapplication666.ui.diary

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication666.database.DatabaseDao
import com.example.myapplication666.database.DiaryModel
import com.example.myapplication666.database.Model

class DiaryViewModel(private val diaryDao: DatabaseDao) : ViewModel() {

    private val _allDiaryLiveData = MutableLiveData<DiaryModel>()
    val allDiaryLiveData: LiveData<DiaryModel> get() = _allDiaryLiveData

    init {
        var data = diaryDao.getAllDiary()
        if (data == null) {
            data = DiaryModel(HashMap())
        }
        _allDiaryLiveData.value = data
    }

    fun saveAllDiary() {
        diaryDao.insertDiaryData(allDiaryLiveData.value!!)
    }

    fun updateList(currentMonth: Months, diaryList: MutableList<Model>) {
        _allDiaryLiveData.value?.let {
            it.data[currentMonth] = diaryList
        }
    }

    fun saveData(currentMonth: Months, dataToSave: List<Model>) {
        if (dataToSave.isEmpty()) {
            throw IllegalStateException()
        }
        _allDiaryLiveData.value?.data?.set(currentMonth, dataToSave)

    }

    fun getDefaultDiaryList(): MutableList<Model> {
        return mutableListOf(Model("Мудрый разум", 0),
            Model("Наблюдение", 0),
            Model("Описание", 0),
            Model("Участие", 0),
            Model("Безоценочность", 0),
            Model("Однозадачность", 0),
            Model("Эффективность", 0),
            Model("СТОП", 0),
            Model("За и против", 0),
            Model("ТРУД", 0),
            Model("ПЕРЕЖИТЬ", 0),
            Model("Самоуспокоение", 0),
            Model("Поправьте момент", 0),
            Model("Радикальное принятие", 0),
            Model("Поворот сознания", 0),
            Model("Готовность", 0),
            Model("Полуулыбка и раскрытые ладони", 0),
            Model("Направленное сознание", 0)
        )
    }
}