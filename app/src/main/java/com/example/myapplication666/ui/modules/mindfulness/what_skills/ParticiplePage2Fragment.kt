package com.example.myapplication666.ui.modules.what_skills

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

class ParticiplePage2Fragment : Fragment() {

    companion object {
        fun newInstance() = ParticiplePage2Fragment()
    }

    private lateinit var viewModel: ParticiplePage2ViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.participle_page2_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ParticiplePage2ViewModel::class.java)
        // TODO: Use the ViewModel
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val buttonParticipleBack = view.findViewById<Button>(R.id.back_btn)
        buttonParticipleBack.setOnClickListener()
        {
            (requireActivity() as MainActivity).popBackStack()
        }
        val buttonParticipleClose = view.findViewById<ImageButton>(R.id.close_btn)
        buttonParticipleClose.setOnClickListener()
        {
            (requireActivity() as MainActivity).popBackStack(R.id.navigation_mindfulness)
        }
    }

}