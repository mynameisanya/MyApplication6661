package com.example.myapplication666.emotional_regulation

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication666.R

class EmotionalRegulationFragment : Fragment() {

    companion object {
        fun newInstance() = EmotionalRegulationFragment()
    }

    private lateinit var viewModel: EmotionalRegulationViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.emotional_regulation_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(EmotionalRegulationViewModel::class.java)
        // TODO: Use the ViewModel
    }

}