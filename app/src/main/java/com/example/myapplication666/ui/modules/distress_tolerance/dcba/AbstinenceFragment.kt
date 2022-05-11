package com.example.myapplication666.ui.modules.distress_tolerance.dcba

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

class AbstinenceFragment : Fragment() {

    companion object {
        fun newInstance() = AbstinenceFragment()
    }

    private lateinit var viewModel: AbstinenceViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.abstinence_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(AbstinenceViewModel::class.java)
        // TODO: Use the ViewModel
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val imageButtonAbstinence = view.findViewById<Button>(R.id.next_btn)
        imageButtonAbstinence.setOnClickListener()
        {
            (requireActivity() as MainActivity).navigationTo(R.id.navigation_abstinence_page2)
        }
        val imageButtonAbstinenceClose = view.findViewById<ImageButton>(R.id.close_btn)
        imageButtonAbstinenceClose.setOnClickListener()
        {
            (requireActivity() as MainActivity).navigationTo(R.id.navigation_dcba)
        }
    }


}