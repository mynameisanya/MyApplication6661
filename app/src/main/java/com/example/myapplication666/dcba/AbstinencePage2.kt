package com.example.myapplication666.dcba

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.myapplication666.MainActivity
import com.example.myapplication666.R

class AbstinencePage2 : Fragment() {

    companion object {
        fun newInstance() = AbstinencePage2()
    }

    private lateinit var viewModel: AbstinencePage2ViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.abstinence_page2_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(AbstinencePage2ViewModel::class.java)
        // TODO: Use the ViewModel
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val imageButtonAbstinencePage3 = view.findViewById<Button>(R.id.next_btn)
        imageButtonAbstinencePage3.setOnClickListener()
        {
            (requireActivity() as MainActivity).navigationTo(R.id.navigation_abstinence_page3)
        }
    }
}