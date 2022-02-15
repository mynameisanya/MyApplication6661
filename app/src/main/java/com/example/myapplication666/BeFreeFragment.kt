package com.example.myapplication666

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class BeFreeFragment : Fragment() {

    companion object {
        fun newInstance() = BeFreeFragment()
    }

    private lateinit var viewModel: BeFreeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.be_free_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(BeFreeViewModel::class.java)
        // TODO: Use the ViewModel
    }

}