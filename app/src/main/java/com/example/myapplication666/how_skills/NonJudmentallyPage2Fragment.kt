package com.example.myapplication666.how_skills

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication666.R

class NonJudmentallyPage2Fragment : Fragment() {

    companion object {
        fun newInstance() = NonJudmentallyPage2Fragment()
    }

    private lateinit var viewModel: NonJudmentallyPage2ViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.non_judmentally_page2_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(NonJudmentallyPage2ViewModel::class.java)
        // TODO: Use the ViewModel
    }

}