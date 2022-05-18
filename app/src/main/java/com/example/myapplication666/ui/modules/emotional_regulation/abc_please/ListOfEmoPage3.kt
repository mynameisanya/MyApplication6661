package com.example.myapplication666.ui.modules.emotional_regulation.abc_please

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

class ListOfEmoPage3 : Fragment() {

    companion object {
        fun newInstance() = ListOfEmoPage3()
    }

    private lateinit var viewModel: ListOfEmoPage3ViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.list_of_emo_page3_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ListOfEmoPage3ViewModel::class.java)
        // TODO: Use the ViewModel
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val imagePositiveBack = view.findViewById<Button>(R.id.back_btn)
        imagePositiveBack.setOnClickListener()
        {
            (requireActivity() as MainActivity).popBackStack()
        }
        val imageButtonPositiveClose = view.findViewById<ImageButton>(R.id.close_btn)
        imageButtonPositiveClose.setOnClickListener()
        {
            (requireActivity() as MainActivity).popBackStack(R.id.navigation_emotional_regulation)
        }
    }

}