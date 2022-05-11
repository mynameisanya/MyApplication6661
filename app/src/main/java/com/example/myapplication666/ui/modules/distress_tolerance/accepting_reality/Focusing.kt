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

class Focusing : Fragment() {

    companion object {
        fun newInstance() = Focusing()
    }

    private lateinit var viewModel: FocusingViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.focusing_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(FocusingViewModel::class.java)
        // TODO: Use the ViewModel
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val imageButtonFocus = view.findViewById<Button>(R.id.next_btn)
        imageButtonFocus.setOnClickListener()
        {
            (requireActivity() as MainActivity).navigationTo(R.id.navigation_focusing_page2)
        }
        val imageButtonFocusClose = view.findViewById<ImageButton>(R.id.close_btn)
        imageButtonFocusClose.setOnClickListener()
        {
            (requireActivity() as MainActivity).navigationTo(R.id.navigation_accepting_reality)
        }
    }

}