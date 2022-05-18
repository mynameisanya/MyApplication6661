package com.example.myapplication666.ui.modules.mindfulness.how_skills

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

class OneMindfullyPage2Fragment : Fragment() {

    companion object {
        fun newInstance() = OneMindfullyPage2Fragment()
    }

    private lateinit var viewModel: OneMindfullyPage2ViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.one_mindfully_page2_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(OneMindfullyPage2ViewModel::class.java)
        // TODO: Use the ViewModel
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val buttonOneMindfullyPage2 = view.findViewById<Button>(R.id.back_btn)
        buttonOneMindfullyPage2.setOnClickListener()
        {
            (requireActivity() as MainActivity).popBackStack()
        }
        val buttonOneMindfullyClose = view.findViewById<ImageButton>(R.id.close_btn)
        buttonOneMindfullyClose.setOnClickListener()
        {
            (requireActivity() as MainActivity).popBackStack(R.id.navigation_mindfulness)
        }
    }

}