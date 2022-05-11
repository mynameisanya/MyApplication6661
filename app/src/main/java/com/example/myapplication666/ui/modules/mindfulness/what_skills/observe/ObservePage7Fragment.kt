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

class ObservePage7Fragment : Fragment() {

    companion object {
        fun newInstance() = ObservePage7Fragment()
    }

    private lateinit var viewModel: ObservePage7ViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.observe_page7_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ObservePage7ViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val buttonObservePage8 = view.findViewById<Button>(R.id.next_btn)
        buttonObservePage8.setOnClickListener()
        {
            (requireActivity() as MainActivity).navigationTo(R.id.navigation_observe_page8)
        }
        val buttonObserveBack = view.findViewById<Button>(R.id.back_btn)
        buttonObserveBack.setOnClickListener()
        {
            (requireActivity() as MainActivity).navigationTo(R.id.navigation_observe_page6)
        }
        val buttonObserveClose = view.findViewById<ImageButton>(R.id.close_btn)
        buttonObserveClose.setOnClickListener()
        {
            (requireActivity() as MainActivity).navigationTo(R.id.navigation_what_skills)
        }
    }

}