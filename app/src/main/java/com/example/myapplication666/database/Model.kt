package com.example.myapplication666.database

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

//описание класса, который сохраняется в бд
@Entity (tableName = "Table_model")
@Parcelize
data class Model(val text: String, var characteristic:Int, @PrimaryKey(autoGenerate = true) val id: Int = (0..Int.MAX_VALUE).random()
):Parcelable {

}