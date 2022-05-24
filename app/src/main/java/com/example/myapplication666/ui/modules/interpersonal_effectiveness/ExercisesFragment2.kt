package com.example.myapplication666.ui.modules.interpersonal_effectiveness

import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication666.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import com.example.myapplication666.database.App

class ExercisesFragment2 : Fragment() {

    companion object {
        fun newInstance() = ExercisesFragment2()
    }

    private val viewModel by viewModels<ExercisesViewModel2> {
        //фабрика для создания вью модели
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return ExercisesViewModel2(App.returnDatabase.returnDao()) as T
            }
        }
    }
    private val adapter = ExpandableAdapter2()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.exercises_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recycler = view.findViewById<RecyclerView>(R.id.recycler)

        val createBtn = view.findViewById<FloatingActionButton>(R.id.create_btn)
        recycler.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        setData()

        recycler.adapter = adapter

        createBtn.setOnClickListener {
            startActivity(Intent(context, CreateExerciseActivity2::class.java))
        }
    }


    override fun onResume() {
        super.onResume()
        setData()
        adapter.notifyDataSetChanged()
    }

    private fun setData() {
        val data = viewModel.getExercises()
        val mutableList = mutableListOf<ListItem2>()
        data.forEach { exercise ->
            val innerItems = mutableListOf<InnerItem2>()
            exercise.value.forEach {
                innerItems.add(InnerItem2(it.first, it.second))
            }


            mutableList.add(
                ExpandableItem2(
                    exercise.date,
                    false,
                    innerItems
                )
            )
        }

        adapter.items = mutableList
    }
}