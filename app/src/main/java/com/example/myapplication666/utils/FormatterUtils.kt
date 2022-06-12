package com.example.myapplication666.utils

import java.text.SimpleDateFormat
import java.util.Locale

fun getDateTextFormatter(time: Long): String {
    val simpleDateFormat = SimpleDateFormat("dd.MM.yyyy", Locale.US)
    return simpleDateFormat.format(time)
}
