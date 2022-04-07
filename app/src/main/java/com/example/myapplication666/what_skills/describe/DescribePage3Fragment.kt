package com.example.myapplication666.what_skills.describe

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication666.R

class DescribePage3Fragment : Fragment() {

    companion object {
        fun newInstance() = DescribePage3Fragment()
    }

    private lateinit var viewModel: DescribePage3ViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.describe_page3_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(DescribePage3ViewModel::class.java)
        // TODO: Use the ViewModel
    }

}