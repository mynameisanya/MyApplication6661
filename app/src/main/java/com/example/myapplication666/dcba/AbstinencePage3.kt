package com.example.myapplication666.dcba

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication666.R

class AbstinencePage3 : Fragment() {

    companion object {
        fun newInstance() = AbstinencePage3()
    }

    private lateinit var viewModel: AbstinencePage3ViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.abstinence_page3_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(AbstinencePage3ViewModel::class.java)
        // TODO: Use the ViewModel
    }

}