package com.example.myapplication666.ui.modules.mindfulness.how_skills

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import com.example.myapplication666.MainActivity
import com.example.myapplication666.R

class HOWSkillsFragment : Fragment() {

    companion object {
        fun newInstance() = HOWSkillsFragment()
    }

    private lateinit var viewModel: HOWSkillsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.how_skills_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(HOWSkillsViewModel::class.java)
        // TODO: Use the ViewModel
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val imageButtonNonJudmentally = view.findViewById<ImageButton>(R.id.non_judgmentally_image)

        imageButtonNonJudmentally.setOnClickListener()
        {
            (requireActivity() as MainActivity).navigationTo(R.id.navigation_non_judmentally)
        }
        val imageButtonOneMindfully = view.findViewById<ImageButton>(R.id.one_mindfully_image)
        imageButtonOneMindfully.setOnClickListener()
        {
            (requireActivity() as MainActivity).navigationTo(R.id.navigation_one_mindfully)
        }
        val imageButtonEffectively = view.findViewById<ImageButton>(R.id.effectively_image)
        imageButtonEffectively.setOnClickListener()
        {
            (requireActivity() as MainActivity).navigationTo(R.id.navigation_effectively)
        }


    }
}