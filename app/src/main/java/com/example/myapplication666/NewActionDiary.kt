package com.example.myapplication666

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication666.database.Model
import com.example.myapplication666.ui.diary.DiaryAdapter
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class NewActionDiary : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.new_action_diary)

        val addAction = findViewById<Button>(R.id.add_action)
        val listAction = findViewById<RecyclerView>(R.id.list_action)
        val diaryList: ArrayList<Model>? = intent.getParcelableArrayListExtra<Model>("New diary")

        val adapter = DiaryAdapter()
        adapter.setData(diaryList!!)
        listAction.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        listAction.adapter = adapter

        addAction.setOnClickListener {
            MaterialAlertDialogBuilder(this).setView(R.layout.new_add_diary).show()
        }
    }



}