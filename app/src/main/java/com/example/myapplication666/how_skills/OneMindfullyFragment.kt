package com.example.myapplication666.how_skills

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication666.R

class OneMindfullyFragment : Fragment() {

    companion object {
        fun newInstance() = OneMindfullyFragment()
    }

    private lateinit var viewModel: OneMindfullyViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.one_mindfully_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(OneMindfullyViewModel::class.java)
        // TODO: Use the ViewModel
    }

}