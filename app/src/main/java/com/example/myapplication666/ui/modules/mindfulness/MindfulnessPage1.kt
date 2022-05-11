package com.example.myapplication666.ui.modules.mindfulness

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import com.example.myapplication666.MainActivity
import com.example.myapplication666.R

class MindfulnessPage1 : Fragment() {

    companion object {
        fun newInstance() = MindfulnessPage1()
    }

    private lateinit var viewModel: MindfulnessPage1ViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.mindfulness_page1_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MindfulnessPage1ViewModel::class.java)
        // TODO: Use the ViewModel
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val buttonMindClose = view.findViewById<ImageButton>(R.id.close_btn)
        buttonMindClose.setOnClickListener()
        {
            (requireActivity() as MainActivity).navigationTo(R.id.navigation_wise_mind)
        }
    }

}