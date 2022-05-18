package com.example.myapplication666.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

//описание базы данных, описываются модели, которые мы сохраняем в бд и интерфейс методов, которые будут доступны в бд
@Database(entities = [Model::class, DiaryModel::class], version = 1, exportSchema = false)
//перечисляются все конвертеры, которые используются бд
@TypeConverters(DiaryModelTypeConverter::class)
abstract class dataBase : RoomDatabase() {

    abstract fun returnDao(): DatabaseDao
}