package com.example.myapplication666.database

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Model
    (var day: String = "", val text: String, var characteristic: Int) : Parcelable