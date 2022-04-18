package com.example.myapplication666.ui.modules.emotional_regulation

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication666.R

class NameOfEmotional : Fragment() {

    companion object {
        fun newInstance() = NameOfEmotional()
    }

    private lateinit var viewModel: NameOfEmotionalViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.name_of_emotional_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(NameOfEmotionalViewModel::class.java)
        // TODO: Use the ViewModel
    }

}