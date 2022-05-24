package com.example.myapplication666.ui.modules.interpersonal_effectiveness

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication666.R

class InterpersonalExercise : Fragment() {

    companion object {
        fun newInstance() = InterpersonalExercise()
    }

    private lateinit var viewModel: InterpersonalExerciseViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.interpersonal_exercise_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(InterpersonalExerciseViewModel::class.java)
        // TODO: Use the ViewModel
    }

}