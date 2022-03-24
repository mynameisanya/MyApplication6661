package com.example.myapplication666.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import androidx.room.Update
//интерфейс, в которм перечислены методы, чтобы работать с бд
@Dao
interface DatabaseDao {
    //вставить модель в бд
    @Insert(onConflict = REPLACE)
    fun insert(model: Model)
    //получить все модели из бд
    @Query ("select * from Table_model")
    fun getAll(): MutableList<Model>
    //обновить
    @Update
    fun updateData(model:Model)
}