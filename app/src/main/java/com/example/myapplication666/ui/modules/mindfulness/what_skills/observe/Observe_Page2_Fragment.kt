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

class Observe_Page2_Fragment : Fragment() {

    companion object {
        fun newInstance() = Observe_Page2_Fragment()
    }

    private lateinit var viewModel: ObservePage2ViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.observe__page2__fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ObservePage2ViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val buttonObservePage3 = view.findViewById<Button>(R.id.next_btn)
        buttonObservePage3.setOnClickListener()
        {
            (requireActivity() as MainActivity).navigationTo(R.id.navigation_observe_page3)
        }
        val buttonObserveBack = view.findViewById<Button>(R.id.back_btn)
        buttonObserveBack.setOnClickListener()
        {
            (requireActivity() as MainActivity).popBackStack()
        }
        val buttonObserveClose = view.findViewById<ImageButton>(R.id.close_btn)
        buttonObserveClose.setOnClickListener()
        {
            (requireActivity() as MainActivity).popBackStack(R.id.navigation_mindfulness)
        }
    }

    }