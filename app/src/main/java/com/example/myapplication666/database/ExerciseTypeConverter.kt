package com.example.myapplication666.database

import androidx.room.TypeConverter
import com.example.myapplication666.ui.diary.Months
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ExerciseTypeConverter {
    @TypeConverter
    //биб-ка гсон, которая берет хэш-карту и преобразует ее в строку, которая является гсоном
    fun fromStringToList(value: String): List<Pair<String, String>> {
        return Gson().fromJson(value, object : TypeToken<List<Pair<String, String>>>() {}.type)
    }

    @TypeConverter
    fun fromMapToString(value: List<Pair<String, String>>): String {
        return Gson().toJson(value)
    }
}