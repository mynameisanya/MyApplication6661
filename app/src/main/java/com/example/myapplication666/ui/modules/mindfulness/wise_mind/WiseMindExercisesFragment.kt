package com.example.myapplication666.ui.modules.mindfulness.wise_mind

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication666.R

class WiseMindExercisesFragment : Fragment() {

    companion object {
        fun newInstance() = WiseMindExercisesFragment()
    }

    private lateinit var viewModel: WiseMindExercisesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.wise_mind_exercises_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(WiseMindExercisesViewModel::class.java)
        // TODO: Use the ViewModel
    }

}