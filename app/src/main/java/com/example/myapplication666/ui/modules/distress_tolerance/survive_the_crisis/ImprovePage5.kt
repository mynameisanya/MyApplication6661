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

class ImprovePage5 : Fragment() {

    companion object {
        fun newInstance() = ImprovePage5()
    }

    private lateinit var viewModel: ImprovePage5ViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.improve_page5_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ImprovePage5ViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val imageButtonImprovePage3 = view.findViewById<Button>(R.id.next_btn)
        imageButtonImprovePage3.setOnClickListener()
        {
            (requireActivity() as MainActivity).navigationTo(R.id.navigation_improve_page6)
        }
        val ButtonImproveBack = view.findViewById<Button>(R.id.back_btn)
        ButtonImproveBack.setOnClickListener()
        {
            (requireActivity() as MainActivity).popBackStack()
        }
        val ButtonImproveClose = view.findViewById<ImageButton>(R.id.close_btn)
        ButtonImproveClose.setOnClickListener()
        {
            (requireActivity() as MainActivity).popBackStack(R.id.navigation_distress_tolerance)
        }
    }

}