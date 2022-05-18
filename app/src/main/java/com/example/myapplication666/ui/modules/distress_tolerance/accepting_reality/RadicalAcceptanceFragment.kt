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

class RadicalAcceptanceFragment : Fragment() {

    companion object {
        fun newInstance() = RadicalAcceptanceFragment()
    }

    private lateinit var viewModel: RadicalAcceptanceViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.radical_acceptance_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(RadicalAcceptanceViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val imageButtonRadicalPage2 = view.findViewById<Button>(R.id.next_btn)
        imageButtonRadicalPage2.setOnClickListener()
        {
            (requireActivity() as MainActivity).navigationTo(R.id.navigation_radical_acceptance_page2)
        }
        val imageButtonRadicalClose = view.findViewById<ImageButton>(R.id.close_btn)
        imageButtonRadicalClose.setOnClickListener()
        {
            (requireActivity() as MainActivity).popBackStack(R.id.navigation_distress_tolerance)
        }
    }

}