package com.example.myapplication666.accepting_reality

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import com.example.myapplication666.MainActivity
import com.example.myapplication666.R

class AcceptingRealityFragment : Fragment() {

    companion object {
        fun newInstance() = AcceptingRealityFragment()
    }

    private lateinit var viewModel: AcceptingRealityViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.accepting_reality_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(AcceptingRealityViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val imageButtonRadical = view.findViewById<ImageButton>(R.id.radical_acceptance_image)
        imageButtonRadical.setOnClickListener()
        {
            (requireActivity() as MainActivity).navigationTo(R.id.navigation_radical_acceptance)
        }
        val imageButtonTuring = view.findViewById<ImageButton>(R.id.turing_your_mind_image)
        imageButtonTuring.setOnClickListener()
        {
            (requireActivity() as MainActivity).navigationTo(R.id.navigation_turing_your_mind)
        }
        val imageButtonWillingness = view.findViewById<ImageButton>(R.id.willingness_image)
        imageButtonWillingness.setOnClickListener()
        {
            (requireActivity() as MainActivity).navigationTo(R.id.navigation_willingness)
        }
        val imageButtonHalfSmile = view.findViewById<ImageButton>(R.id.half_smile_image)
        imageButtonHalfSmile.setOnClickListener()
        {
            (requireActivity() as MainActivity).navigationTo(R.id.navigation_half_smile)
        }

    }

}