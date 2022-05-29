package com.example.myapplication666.ui.modules.interpersonal_effectiveness

import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication666.R
import com.example.myapplication666.database.App
import com.example.myapplication666.ui.modules.emotional_regulation.*
import com.google.android.material.floatingactionbutton.FloatingActionButton

class InterpersonalExerciseFragment : Fragment() {
    companion object {
        fun newInstance() = InterpersonalExerciseFragment()
    }

    private val viewModel by viewModels<InterpersonalExerciseViewModel> {
        //фабрика для создания вью модели
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return InterpersonalExerciseViewModel(App.returnDatabase.returnDao()) as T
            }
        }
    }
    private val adapter = ExpandableAdapter()
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
            startActivity(Intent(context, CreateInterpersonalExercise::class.java))
        }
    }


    override fun onResume() {
        super.onResume()
        setData()
        adapter.notifyDataSetChanged()
    }

    private fun setData() {
        val data = viewModel.getExercises()
        val mutableList = mutableListOf<ListItem>()
        data.forEach { exercise ->
            val innerItems = mutableListOf<InnerItem>()
            exercise.value.forEach {
                innerItems.add(InnerItem(it.first, it.second))
            }


            mutableList.add(
                ExpandableItem(
                    exercise.date,
                    false,
                    innerItems
                )
            )
        }

        adapter.items = mutableList
    }

}