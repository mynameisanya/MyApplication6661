package com.example.myapplication666.what_skills.observe

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.myapplication666.MainActivity
import com.example.myapplication666.R

class ObservePage6Fragment : Fragment() {

    companion object {
        fun newInstance() = ObservePage6Fragment()
    }

    private lateinit var viewModel: ObservePage6ViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.observe_page6_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ObservePage6ViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val buttonObservePage7 = view.findViewById<Button>(R.id.next_btn)
        buttonObservePage7.setOnClickListener()
        {
            (requireActivity() as MainActivity).navigationTo(R.id.navigation_observe_page7)
        }

    }

}