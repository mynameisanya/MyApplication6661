package com.example.myapplication666.ui.modules.emotional_regulation

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication666.R

class CreateExerciseActivity:AppCompatActivity() {

    val adapter = ExercisesAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activitity_create_exercise)
        val save = findViewById<Button>(R.id.save_btn)
        save.setOnClickListener()
        {
            val adapterList = adapter.list
            Rep.list = adapterList
            finish()
        }
        val recycler = findViewById<RecyclerView>(R.id.recycler)
        recycler.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recycler.adapter = adapter

    }
}