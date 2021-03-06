package com.example.myapplication666.accepting_reality

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication666.R

class AcceptingRealityFragment : Fragment() {

    companion object {
        fun newInstance() = AcceptingRealityFragment()
    }

    private lateinit var viewModel: AcceptingRealityViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.accepting_reality_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(AcceptingRealityViewModel::class.java)
        // TODO: Use the ViewModel
    }

}