package com.example.myapplication666.ui.modules.what_skills

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication666.R

class ParticiplePage2Fragment : Fragment() {

    companion object {
        fun newInstance() = ParticiplePage2Fragment()
    }

    private lateinit var viewModel: ParticiplePage2ViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.participle_page2_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ParticiplePage2ViewModel::class.java)
        // TODO: Use the ViewModel
    }

}