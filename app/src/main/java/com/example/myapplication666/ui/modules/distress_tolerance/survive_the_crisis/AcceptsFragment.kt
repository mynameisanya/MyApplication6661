package com.example.myapplication666.ui.modules.distress_tolerance.survive_the_crisis

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

class AcceptsFragment : Fragment() {

    companion object {
        fun newInstance() = AcceptsFragment()
    }

    private lateinit var viewModel: AcceptsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.accepts_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(AcceptsViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val buttonAcceptsNext = view.findViewById<Button>(R.id.next_btn)
        buttonAcceptsNext.setOnClickListener()
        {
            (requireActivity() as MainActivity).navigationTo(R.id.navigation_accepts_page2)
        }
        val buttonEffectivelyClose = view.findViewById<ImageButton>(R.id.close_btn)
        buttonEffectivelyClose.setOnClickListener()
        {
            (requireActivity() as MainActivity).navigationTo(R.id.navigation_survive_the_crisis)
        }
    }

}