package com.example.myapplication666.ui.modules.emotional_regulation.abc_please

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import com.example.myapplication666.MainActivity
import com.example.myapplication666.R

class Care : Fragment() {

    companion object {
        fun newInstance() = Care()
    }

    private lateinit var viewModel: CareViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.care_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(CareViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val imageClose = view.findViewById<ImageButton>(R.id.close_btn)
        imageClose.setOnClickListener()
        {
            (requireActivity() as MainActivity).navigationTo(R.id.navigation_abc_please)
        }
        }

}