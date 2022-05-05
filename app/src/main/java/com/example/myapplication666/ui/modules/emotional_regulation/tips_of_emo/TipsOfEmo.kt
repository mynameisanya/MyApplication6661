package com.example.myapplication666.ui.modules.emotional_regulation.tips_of_emo

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication666.R

class TipsOfEmo : Fragment() {

    companion object {
        fun newInstance() = TipsOfEmo()
    }

    private lateinit var viewModel: TipsOfEmoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.tips_of_emo_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(TipsOfEmoViewModel::class.java)
        // TODO: Use the ViewModel
    }

}