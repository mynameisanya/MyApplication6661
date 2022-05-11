package com.example.myapplication666.ui.modules.distress_tolerance.survive_the_crisis

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

class SelfSoothePage3Fragment : Fragment() {

    companion object {
        fun newInstance() = SelfSoothePage3Fragment()
    }

    private lateinit var viewModel: SelfSoothePage3ViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.self_soothe_page3_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SelfSoothePage3ViewModel::class.java)
        // TODO: Use the ViewModel
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val imageButtonSelfSootheBack = view.findViewById<Button>(R.id.back_btn)
        imageButtonSelfSootheBack.setOnClickListener()
        {
            (requireActivity() as MainActivity).navigationTo(R.id.navigation_self_soothe_page2)
        }
        val imageButtonSelfSootheClose = view.findViewById<ImageButton>(R.id.close_btn)
        imageButtonSelfSootheClose.setOnClickListener()
        {
            (requireActivity() as MainActivity).navigationTo(R.id.navigation_survive_the_crisis)
        }
    }
}