package com.example.myapplication666.ui.modules.emotional_regulation

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication666.R
import com.example.myapplication666.database.App
import com.example.myapplication666.database.DataExercise
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ExercisesFragment : Fragment() {

    companion object {
        fun newInstance() = ExercisesFragment()
    }

    private val viewModel by viewModels<ExercisesViewModel> {
        //фабрика для создания вью модели
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return ExercisesViewModel(App.returnDatabase.returnDao()) as T
            }
        }
    }
    private lateinit var adapter: ExpandableAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.exercises_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = ExpandableAdapter { expandableItem ->
            createDialog(expandableItem)
        }
        val recycler = view.findViewById<RecyclerView>(R.id.recycler)

        val createBtn = view.findViewById<FloatingActionButton>(R.id.create_btn)
        recycler.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        setData()

        recycler.adapter = adapter

        createBtn.setOnClickListener {
            startActivity(Intent(context, CreateExerciseActivity::class.java))
        }
    }

    private fun createDialog(expandableItem: ExpandableItem) {
        MaterialAlertDialogBuilder(requireContext())
            .setTitle(resources.getString(R.string.delete_exercise))
            .setMessage(resources.getString(R.string.are_you_sure_to_delete))
            .setNegativeButton(resources.getString(R.string.cancel)) { dialog, which ->
                // Respond to negative button press
            }
            .setPositiveButton(resources.getString(R.string.ok)) { dialog, which ->
                deleteExercise(expandableItem)
            }
            .show()
    }

    private fun deleteExercise(expandableItem: ExpandableItem) {
        val position = adapter.items!!.indexOf(expandableItem)
        val data = viewModel.getExercises()
        val exercise = data.find { dataExercise ->
            dataExercise.date == expandableItem.text && isListEquals(expandableItem, dataExercise)
        }
        exercise?.let {
            viewModel.deleteExercise(it)
            setData()
            adapter.notifyItemRemoved(position)
        }
    }

    private fun isListEquals(expandableItem: ExpandableItem, data: DataExercise): Boolean {
        for (i in 0 until expandableItem.innerItems.size) {
            if (expandableItem.innerItems[i].title != data.value[i].first &&
                expandableItem.innerItems[i].description != data.value[i].second
            ) {
                return false
            }
        }

        return true
    }


    override fun onResume() {
        super.onResume()
        setData()
        adapter?.notifyDataSetChanged()
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

        adapter?.items = mutableList
    }
}