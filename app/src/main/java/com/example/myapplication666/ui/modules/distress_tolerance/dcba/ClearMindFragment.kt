package com.example.myapplication666.ui.modules.distress_tolerance.dcba

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication666.R

class ClearMindFragment : Fragment() {

    companion object {
        fun newInstance() = ClearMindFragment()
    }

    private lateinit var viewModel: ClearMindViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.clear_mind_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ClearMindViewModel::class.java)
        // TODO: Use the ViewModel
    }

}