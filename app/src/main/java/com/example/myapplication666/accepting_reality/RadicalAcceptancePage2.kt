package com.example.myapplication666.accepting_reality

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication666.R

class RadicalAcceptancePage2 : Fragment() {

    companion object {
        fun newInstance() = RadicalAcceptancePage2()
    }

    private lateinit var viewModel: RadicalAcceptancePage2ViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.radical_acceptance_page2_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(RadicalAcceptancePage2ViewModel::class.java)
        // TODO: Use the ViewModel
    }

}