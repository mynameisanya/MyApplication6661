package com.example.myapplication666.dcba

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication666.R

class AbstinenceFragment : Fragment() {

    companion object {
        fun newInstance() = AbstinenceFragment()
    }

    private lateinit var viewModel: AbstinenceViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.abstinence_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(AbstinenceViewModel::class.java)
        // TODO: Use the ViewModel
    }

}