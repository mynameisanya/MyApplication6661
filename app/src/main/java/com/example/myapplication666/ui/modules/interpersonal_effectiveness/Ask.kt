package com.example.myapplication666.ui.modules.interpersonal_effectiveness

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import com.example.myapplication666.MainActivity
import com.example.myapplication666.R

class Ask : Fragment() {

    companion object {
        fun newInstance() = Ask()
    }

    private lateinit var viewModel: AskViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.ask_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(AskViewModel::class.java)
        // TODO: Use the ViewModel
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val imageButtonClose = view.findViewById<ImageButton>(R.id.close_btn)
        imageButtonClose.setOnClickListener()
        {
            (requireActivity() as MainActivity).popBackStack(R.id.navigation_interpersonal_effectiveness)
        }
    }
}