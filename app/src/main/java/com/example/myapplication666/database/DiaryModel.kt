package com.example.myapplication666.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.myapplication666.ui.diary.Months
import java.io.Serializable

@Entity(tableName = "table_diary")
data class DiaryModel(
    val data: HashMap<Months, List<Model>>,
    @PrimaryKey(autoGenerate = true) val id: Int = 0
) : Serializable