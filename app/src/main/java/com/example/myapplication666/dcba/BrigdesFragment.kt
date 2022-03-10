package com.example.myapplication666.dcba

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication666.R

class BrigdesFragment : Fragment() {

    companion object {
        fun newInstance() = BrigdesFragment()
    }

    private lateinit var viewModel: BrigdesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.brigdes_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(BrigdesViewModel::class.java)
        // TODO: Use the ViewModel
    }

}