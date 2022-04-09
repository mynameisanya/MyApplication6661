package com.example.myapplication666.survive_the_crisis

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication666.R

class SelfSoothePage3Fragment : Fragment() {

    companion object {
        fun newInstance() = SelfSoothePage3Fragment()
    }

    private lateinit var viewModel: SelfSoothePage3ViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.self_soothe_page3_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SelfSoothePage3ViewModel::class.java)
        // TODO: Use the ViewModel
    }

}