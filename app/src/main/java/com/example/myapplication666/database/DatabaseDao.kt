package com.example.myapplication666.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query

//интерфейс, в которм перечислены методы, чтобы работать с бд
@Dao
interface DatabaseDao {
    @Insert(onConflict = REPLACE)
    fun insertDiaryData(data: DiaryModel)

    //получить все модели из бд
    @Query("select * from table_diary")
    fun getAllDiary(): DiaryModel
}