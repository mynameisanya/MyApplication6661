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

class EffectivelyFragment : Fragment() {

    companion object {
        fun newInstance() = EffectivelyFragment()
    }

    private lateinit var viewModel: EffectivelyViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.effectively_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(EffectivelyViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val buttonEffectivelyPage2 = view.findViewById<Button>(R.id.next_btn)
        buttonEffectivelyPage2.setOnClickListener()
        {
            (requireActivity() as MainActivity).navigationTo(R.id.navigation_effectively_page2)
        }
        val buttonEffectivelyClose = view.findViewById<ImageButton>(R.id.close_btn)
        buttonEffectivelyClose.setOnClickListener()
        {
            (requireActivity() as MainActivity).navigationTo(R.id.navigation_how_skills)
        }
    }

}