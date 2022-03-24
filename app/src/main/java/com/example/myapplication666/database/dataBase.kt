package com.example.myapplication666.database

import androidx.room.Database
import androidx.room.RoomDatabase
//описание базы данных, описываются модели, которые мы сохраняем в бд и интерфейс методов, которые будут доступны в бд
@Database(entities = [Model::class], version = 1, exportSchema = false)
abstract class dataBase : RoomDatabase() {

    abstract fun returnDao (): DatabaseDao
}