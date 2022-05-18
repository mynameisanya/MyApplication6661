package com.example.myapplication666.ui.modules.emotional_regulation.emotions

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

class MythsOfEmo : Fragment() {

    companion object {
        fun newInstance() = MythsOfEmo()
    }

    private lateinit var viewModel: MythsOfEmoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.myths_of_emo_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MythsOfEmoViewModel::class.java)
        // TODO: Use the ViewModel
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val imageButtonPositiveClose = view.findViewById<ImageButton>(R.id.close_btn)
        imageButtonPositiveClose.setOnClickListener()
        {
            (requireActivity() as MainActivity).popBackStack(R.id.navigation_emotional_regulation)
        }
    }
}