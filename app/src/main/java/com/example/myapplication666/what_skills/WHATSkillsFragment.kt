package com.example.myapplication666.what_skills

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication666.R
import com.example.myapplication666.wise_mind.WiseMindViewModel

class WHATSkillsFragment : Fragment() {

    companion object {
        fun newInstance() = WHATSkillsFragment()
    }

    private lateinit var viewModel: WiseMindViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.what_skills_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(WiseMindViewModel::class.java)
        // TODO: Use the ViewModel
    }

}