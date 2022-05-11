package com.example.myapplication666.ui.modules.distress_tolerance.accepting_reality

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import com.example.myapplication666.MainActivity
import com.example.myapplication666.R

class RadicalAcceptancePage2 : Fragment() {

    companion object {
        fun newInstance() = RadicalAcceptancePage2()
    }

    private lateinit var viewModel: RadicalAcceptancePage2ViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.radical_acceptance_page2_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(RadicalAcceptancePage2ViewModel::class.java)
        // TODO: Use the ViewModel
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val imageButtonRadicalPage2 = view.findViewById<Button>(R.id.back_btn)
        imageButtonRadicalPage2.setOnClickListener()
        {
            (requireActivity() as MainActivity).navigationTo(R.id.navigation_radical_acceptance)
        }
        val imageButtonRadicalClose = view.findViewById<ImageButton>(R.id.close_btn)
        imageButtonRadicalClose.setOnClickListener()
        {
            (requireActivity() as MainActivity).navigationTo(R.id.navigation_accepting_reality)
        }
    }

}