package com.example.myapplication666.database

import android.os.Parcelable
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Model
    (val text: String, var characteristic:Int):Parcelable