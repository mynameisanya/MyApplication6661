package com.example.myapplication666.how_skills

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication666.R

class EffectivelyFragment : Fragment() {

    companion object {
        fun newInstance() = EffectivelyFragment()
    }

    private lateinit var viewModel: EffectivelyViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.effectively_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(EffectivelyViewModel::class.java)
        // TODO: Use the ViewModel
    }

}