package com.example.myapplication666.viewModels

import com.example.myapplication666.database.DatabaseDao
import com.example.myapplication666.database.Model
import com.example.myapplication666.ui.diary.NewDiaryViewModel
import com.example.myapplication666.utils.ViewModelTestingRules
import io.mockk.MockK
import io.mockk.MockKAnnotations
import io.mockk.mockk
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class NewDiaryViewModelTest {
    //обьявление правила, по которому тестируется вью модель
    @get:Rule
    val viewModelRule = ViewModelTestingRules()
    //объявление вью модели и базы данных
    lateinit var newDiaryViewModel: NewDiaryViewModel
    //аннотация, чтобы не нужно было инициализировать вручную это поле
    @io.mockk.impl.annotations.MockK(relaxed = true)
    lateinit var newDiaryDao: DatabaseDao

//методзапускающийся перед каждым тестом
    @Before
    fun setUp()
    {
        //инициализация бибки мокко
        MockKAnnotations.init(this)
        //инициализация вью модели
        newDiaryViewModel = NewDiaryViewModel(newDiaryDao)
    }

    @Test(expected = IllegalStateException::class)
    fun saveDataForThrow()
    {
        val model = emptyList<Model>()
        newDiaryViewModel.saveData(model)

    }

//    @Test
//    fun getList()
//    {
//        val data = newDiaryDao.getAll()
//        if (data.isEmpty()) {
//            return mutableListOf(Model("One", 3), Model("Two", 2), Model("Three", 4))
//        }
//        return data
//    }
}