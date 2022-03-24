package com.example.myapplication666.ui.diary

import com.example.myapplication666.database.Model

interface OnChangeSeekBarListener {
    fun onChanged(diaryList:MutableList<Model>)
}