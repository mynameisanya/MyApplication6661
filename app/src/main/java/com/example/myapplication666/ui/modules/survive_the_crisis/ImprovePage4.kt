package com.example.myapplication666.ui.modules.survive_the_crisis

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

class ImprovePage4 : Fragment() {

    companion object {
        fun newInstance() = ImprovePage4()
    }

    private lateinit var viewModel: ImprovePage4ViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.improve_page4_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ImprovePage4ViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val imageButtonImprovePage5 = view.findViewById<Button>(R.id.next_btn)
        imageButtonImprovePage5.setOnClickListener()
        {
            (requireActivity() as MainActivity).navigationTo(R.id.navigation_improve_page5)
        }
    }

}