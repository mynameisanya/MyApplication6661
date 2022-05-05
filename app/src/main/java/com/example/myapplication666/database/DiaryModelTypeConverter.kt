package com.example.myapplication666.database

import androidx.room.TypeConverter
import com.example.myapplication666.ui.diary.Months
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class DiaryModelTypeConverter {
    @TypeConverter
    fun fromStringToMap(value: String): HashMap<Months, List<Model>> {
        return Gson().fromJson(value, object : TypeToken<HashMap<Months, List<Model>>>() {}.type)
    }

    @TypeConverter
    fun fromMapToString(map: HashMap<Months, List<Model>>): String {
        return Gson().toJson(map)
    }
}