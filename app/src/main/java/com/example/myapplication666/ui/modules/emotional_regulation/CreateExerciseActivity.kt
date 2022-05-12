package com.example.myapplication666.ui.modules.emotional_regulation

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication666.R

class CreateExerciseActivity : AppCompatActivity() {

    val adapter = ExercisesAdapter()

    private var titleEditText:EditText? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activitity_create_exercise)
        val save = findViewById<Button>(R.id.save_btn)
        titleEditText = findViewById(R.id.title_edit_text)
        save.setOnClickListener()
        {
            val adapterList = adapter.list
            Rep.list = adapterList
            Rep.title = titleEditText?.text.toString()
            finish()
        }
        val recycler = findViewById<RecyclerView>(R.id.recycler)
        recycler.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        val data = listOf(
            getString(R.string.step_one) to "",
            getString(R.string.step_two) to "",
            getString(R.string.step_three) to "",
            getString(R.string.step_four) to "",
            getString(R.string.step_five) to "",
            getString(R.string.step_six) to ""
        )

        adapter.setData(data)
        recycler.adapter = adapter

    }
}