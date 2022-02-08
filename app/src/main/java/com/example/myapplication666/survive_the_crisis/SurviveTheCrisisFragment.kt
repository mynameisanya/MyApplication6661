package com.example.myapplication666.survive_the_crisis

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication666.R

class SurviveTheCrisisFragment : Fragment() {

    companion object {
        fun newInstance() = SurviveTheCrisisFragment()
    }

    private lateinit var viewModel: SurviveTheCrisisViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.survive_the_crisis_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SurviveTheCrisisViewModel::class.java)
        // TODO: Use the ViewModel
    }

}