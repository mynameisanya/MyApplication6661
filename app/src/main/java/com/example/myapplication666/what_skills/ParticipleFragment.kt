package com.example.myapplication666.what_skills

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication666.R

class ParticipleFragment : Fragment() {

    companion object {
        fun newInstance() = ParticipleFragment()
    }

    private lateinit var viewModel: ParticipleViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.participle_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ParticipleViewModel::class.java)
        // TODO: Use the ViewModel
    }

}