package com.example.myapplication666.ui.modules.emotional_regulation

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication666.R
import com.example.myapplication666.database.App
import com.example.myapplication666.database.DataExercise
import com.example.myapplication666.ui.diary.DiaryViewModel


class CreateExerciseActivity : AppCompatActivity() {

    val adapter = ExercisesAdapter()

    private var titleEditText:EditText? = null

    private val viewModel by viewModels<ExercisesViewModel> {
        //фабрика для создания вью модели
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return ExercisesViewModel(App.returnDatabase.returnDao()) as T
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activitity_create_exercise)
        val save = findViewById<Button>(R.id.save_btn)
        titleEditText = findViewById(R.id.title_edit_text)
        save.setOnClickListener()
        {
            val adapterList = adapter.list.filter {
                it.second.isNotEmpty()
            }
            if(titleEditText!!.text.isEmpty() || adapterList.isEmpty())
            {
                Toast.makeText(this@CreateExerciseActivity, "Необходимо заполнить данные", Toast.LENGTH_SHORT).show()
            }
            else
            {
                val data = DataExercise(titleEditText?.text.toString(), adapterList)
                viewModel.insertExercises(data)
                finish()
            }
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