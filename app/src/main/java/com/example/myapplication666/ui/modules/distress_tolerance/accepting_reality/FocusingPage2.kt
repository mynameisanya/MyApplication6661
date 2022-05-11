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

class FocusingPage2 : Fragment() {

    companion object {
        fun newInstance() = FocusingPage2()
    }

    private lateinit var viewModel: FocusingPage2ViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.focusing_page2_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(FocusingPage2ViewModel::class.java)
        // TODO: Use the ViewModel
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val imageButtonFocusBack = view.findViewById<Button>(R.id.back_btn)
        imageButtonFocusBack.setOnClickListener()
        {
            (requireActivity() as MainActivity).navigationTo(R.id.navigation_focusing)
        }
        val imageButtonFocusClose = view.findViewById<ImageButton>(R.id.close_btn)
        imageButtonFocusClose.setOnClickListener()
        {
            (requireActivity() as MainActivity).navigationTo(R.id.navigation_accepting_reality)
        }
    }

}