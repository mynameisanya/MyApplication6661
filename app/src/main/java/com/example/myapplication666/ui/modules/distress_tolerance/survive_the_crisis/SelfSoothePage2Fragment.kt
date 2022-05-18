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

class SelfSoothePage2Fragment : Fragment() {

    companion object {
        fun newInstance() = SelfSoothePage2Fragment()
    }

    private lateinit var viewModel: SelfSoothePage2ViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.self_smoothe_page2_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SelfSoothePage2ViewModel::class.java)
        // TODO: Use the ViewModel
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val imageButtonSelfSoothePage3 = view.findViewById<Button>(R.id.next_btn)
        imageButtonSelfSoothePage3.setOnClickListener()
        {
            (requireActivity() as MainActivity).navigationTo(R.id.navigation_self_soothe_page3)
        }
        val imageButtonSelfSootheBack = view.findViewById<Button>(R.id.back_btn)
        imageButtonSelfSootheBack.setOnClickListener()
        {
            (requireActivity() as MainActivity).popBackStack()
        }
        val imageButtonSelfSootheClose = view.findViewById<ImageButton>(R.id.close_btn)
        imageButtonSelfSootheClose.setOnClickListener()
        {
            (requireActivity() as MainActivity).popBackStack(R.id.navigation_distress_tolerance)
        }
    }

}