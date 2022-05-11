package com.example.myapplication666.ui.modules.distress_tolerance.dcba

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication666.R

class RefusalFragment : Fragment() {

    companion object {
        fun newInstance() = RefusalFragment()
    }

    private lateinit var viewModel: RefusalViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.refusal_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(RefusalViewModel::class.java)
        // TODO: Use the ViewModel
    }

}