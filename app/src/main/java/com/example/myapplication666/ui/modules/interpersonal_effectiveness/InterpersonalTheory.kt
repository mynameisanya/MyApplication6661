package com.example.myapplication666.ui.modules.interpersonal_effectiveness

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import com.example.myapplication666.MainActivity
import com.example.myapplication666.R

class InterpersonalTheory : Fragment() {

    companion object {
        fun newInstance() = InterpersonalTheory()
    }

    private lateinit var viewModel: InterpersonalTheoryViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.interpersonal_theory_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(InterpersonalTheoryViewModel::class.java)
        // TODO: Use the ViewModel
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val imageButtonAsk = view.findViewById<ImageButton>(R.id.ask)
        imageButtonAsk.setOnClickListener()
        {
            (requireActivity() as MainActivity).navigationTo(R.id.navigation_ask)
        }
        val imageButtonFriend = view.findViewById<ImageButton>(R.id.friend)
        imageButtonFriend.setOnClickListener()
        {
            (requireActivity() as MainActivity).navigationTo(R.id.navigation_friend)
        }
//        val imageButtonHonor = view.findViewById<ImageButton>(R.id.honor)
//        imageButtonHonor.setOnClickListener()
//        {
//            (requireActivity() as MainActivity).navigationTo(R.id.navigation_honor)
//        }
    }
}