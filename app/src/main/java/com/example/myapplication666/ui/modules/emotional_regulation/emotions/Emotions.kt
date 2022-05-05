package com.example.myapplication666.ui.modules.emotional_regulation.emotions

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import com.example.myapplication666.MainActivity
import com.example.myapplication666.R

class Emotions : Fragment() {

    companion object {
        fun newInstance() = Emotions()
    }

    private lateinit var viewModel: EmotionsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.emotions_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(EmotionsViewModel::class.java)
        // TODO: Use the ViewModel
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val imageButtonPurpose = view.findViewById<ImageButton>(R.id.purpose_emotional)
        imageButtonPurpose?.setOnClickListener()
        {
            (requireActivity() as MainActivity).navigationTo(R.id.navigation_purpose_emotional)
        }
        val imageButtonName = view.findViewById<ImageButton>(R.id.name_of_emotional)
        imageButtonName?.setOnClickListener()
        {
            (requireActivity() as MainActivity).navigationTo(R.id.navigation_name_of_emotional)
        }
        val imageButtonMyths = view.findViewById<ImageButton>(R.id.myths_of_emo)
        imageButtonMyths?.setOnClickListener()
        {
            (requireActivity() as MainActivity).navigationTo(R.id.navigation_myths_of_emo)
        }
    }

}