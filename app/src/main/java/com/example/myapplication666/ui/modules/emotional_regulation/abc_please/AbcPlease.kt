package com.example.myapplication666.ui.modules.emotional_regulation.abc_please

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication666.R

class AbcPlease : Fragment() {

    companion object {
        fun newInstance() = AbcPlease()
    }

    private lateinit var viewModel: AbcPleaseViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.abc_please_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(AbcPleaseViewModel::class.java)
        // TODO: Use the ViewModel
    }

}