package com.example.myapplication666.ui.modules.emotional_regulation

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication666.R

class TheoryFragment : Fragment() {

    companion object {
        fun newInstance() = TheoryFragment()
    }

    private lateinit var viewModel: TheoryViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.theory_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(TheoryViewModel::class.java)
        // TODO: Use the ViewModel
    }

}