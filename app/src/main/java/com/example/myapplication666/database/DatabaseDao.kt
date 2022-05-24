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

    @Insert (onConflict = REPLACE)
    fun insertExercise(data: DataExercise)
    @Query ("select * from DataExercise")
    fun getAllExercise(): List<DataExercise>


    @Insert (onConflict = REPLACE)
    fun insertExercise2(data: DataExercise2)
    @Query ("select * from DataExercise2")
    fun getAllExercise2(): List<DataExercise2>
}