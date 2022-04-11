package com.example.myapplication666.ui.modules.survive_the_crisis

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication666.R

class AcceptsPage2 : Fragment() {

    companion object {
        fun newInstance() = AcceptsPage2()
    }

    private lateinit var viewModel: AcceptsPage2ViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.accepts_page2_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(AcceptsPage2ViewModel::class.java)
        // TODO: Use the ViewModel
    }

}