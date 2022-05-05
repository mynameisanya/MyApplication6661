package com.example.myapplication666.ui.modules.distress_tolerance.survive_the_crisis

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import com.example.myapplication666.MainActivity
import com.example.myapplication666.R

class SurviveTheCrisisFragment : Fragment() {

    companion object {
        fun newInstance() = SurviveTheCrisisFragment()
    }

    private lateinit var viewModel: SurviveTheCrisisViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.survive_the_crisis_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SurviveTheCrisisViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val imageButtonStop = view.findViewById<ImageButton>(R.id.stop_image)
        imageButtonStop.setOnClickListener()
        {
            (requireActivity() as MainActivity).navigationTo(R.id.navigation_stop)
        }
        val imageButtonProsAndCons = view.findViewById<ImageButton>(R.id.pros_and_cons_image)
        imageButtonProsAndCons.setOnClickListener()
        {
            (requireActivity() as MainActivity).navigationTo(R.id.navigation_pros_and_cons)
        }
        val imageButtonTIP = view.findViewById<ImageButton>(R.id.tip_image)
        imageButtonTIP.setOnClickListener()
        {
            (requireActivity() as MainActivity).navigationTo(R.id.navigation_tip)
        }

        val imageButtonAccepts = view.findViewById<ImageButton>(R.id.accepts_image)
        imageButtonAccepts.setOnClickListener()
        {
            (requireActivity() as MainActivity).navigationTo(R.id.navigation_accepts)
        }
        val imageButtonSelfSoothe = view.findViewById<ImageButton>(R.id.self_soothe_image)
        imageButtonSelfSoothe.setOnClickListener()
        {
            (requireActivity() as MainActivity).navigationTo(R.id.navigation_self_soothe)
        }
        val imageButtonImprove = view.findViewById<ImageButton>(R.id.improve_image)
        imageButtonImprove.setOnClickListener()
        {
            (requireActivity() as MainActivity).navigationTo(R.id.navigation_improve)
        }

    }
}