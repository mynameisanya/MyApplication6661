package com.example.myapplication666.ui.modules.mindfulness.wise_mind

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import com.example.myapplication666.MainActivity
import com.example.myapplication666.R

class WiseMindPage1Fragment : Fragment() {

    companion object {
        fun newInstance() = WiseMindPage1Fragment()
    }

    private lateinit var viewModel: WiseMindPage1ViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.wise_mind_page1_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(WiseMindPage1ViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val buttonWiseClose = view.findViewById<ImageButton>(R.id.close_btn)
        buttonWiseClose.setOnClickListener()
        {
            (requireActivity() as MainActivity).navigationTo(R.id.navigation_wise_mind)
        }
    }

}