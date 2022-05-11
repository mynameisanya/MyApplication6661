package com.example.myapplication666.ui.modules.what_skills.observe

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

class ObservePage5Fragment : Fragment() {

    companion object {
        fun newInstance() = ObservePage5Fragment()
    }

    private lateinit var viewModel: ObservePage5ViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.observe_page5_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ObservePage5ViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val buttonObservePage6 = view.findViewById<Button>(R.id.next_btn)
        buttonObservePage6.setOnClickListener()
        {
            (requireActivity() as MainActivity).navigationTo(R.id.navigation_observe_page6)
        }
        val buttonObserveBack = view.findViewById<Button>(R.id.back_btn)
        buttonObserveBack.setOnClickListener()
        {
            (requireActivity() as MainActivity).navigationTo(R.id.navigation_observe_page4)
        }
        val buttonObserveClose = view.findViewById<ImageButton>(R.id.close_btn)
        buttonObserveClose.setOnClickListener()
        {
            (requireActivity() as MainActivity).navigationTo(R.id.navigation_what_skills)
        }
    }
    }
