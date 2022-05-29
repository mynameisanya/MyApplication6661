package com.example.myapplication666.ui.modules.emotional_regulation.tips_of_emo

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import com.example.myapplication666.MainActivity
import com.example.myapplication666.R
import com.example.myapplication666.ui.modules.emotional_regulation.emotions.MythsOfEmoViewModel

class Fear : Fragment() {

    companion object {
        fun newInstance() = Fear()
    }

    private lateinit var viewModel: FearViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fear_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(FearViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val imageButtonClose = view.findViewById<ImageButton>(R.id.close_btn)
        imageButtonClose.setOnClickListener()
        {
            (requireActivity() as MainActivity).popBackStack(R.id.navigation_tips_of_emo)
        }
    }

}