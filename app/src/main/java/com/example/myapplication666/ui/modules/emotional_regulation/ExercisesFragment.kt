package com.example.myapplication666.ui.modules.emotional_regulation

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

class ExercisesFragment : Fragment() {

    companion object {
        fun newInstance() = ExercisesFragment()
    }

    private lateinit var viewModel: ExercisesViewModel

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

        adapter.items = listOf(
            ExpandableItem(
                "One expanded",
                false,
                listOf(InnerItem("One Inner", "EditText1"), InnerItem("Two inner","EditText2"), InnerItem("Third inner","EditText2"))
            ),
            ExpandableItem(
                "Two expanded",
                true,
                listOf(InnerItem("One Inner", "EditText1"), InnerItem("Two inner","EditText2"), InnerItem("Third inner","EditText2"))
            ),
        )

        recycler.adapter = adapter

        createBtn.setOnClickListener {
            startActivity(Intent(context, CreateExerciseActivity::class.java))
        }
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ExercisesViewModel::class.java)
        // TODO: Use the ViewModel
    }

}