package com.example.myapplication666.database

import android.app.Application
import androidx.room.Room
import androidx.room.RoomDatabase

//запускает первым при запуске приложения
class App : Application() {

    override fun onCreate() {
        super.onCreate()
        //инициализация бд
        returnDatabase =
            Room.databaseBuilder(applicationContext, dataBase::class.java, "exampleDatabase")
                .allowMainThreadQueries().build()

    }

    companion object {
        lateinit var returnDatabase: dataBase

    }
}