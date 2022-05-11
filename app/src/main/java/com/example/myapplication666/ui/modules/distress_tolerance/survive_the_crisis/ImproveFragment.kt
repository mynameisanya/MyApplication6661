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

class ImproveFragment : Fragment() {

    companion object {
        fun newInstance() = ImproveFragment()
    }

    private lateinit var viewModel: ImproveViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.improve_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ImproveViewModel::class.java)
        // TODO: Use the ViewModel
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val buttonImprovePage2 = view.findViewById<Button>(R.id.next_btn)
        buttonImprovePage2.setOnClickListener()
        {
            (requireActivity() as MainActivity).navigationTo(R.id.navigation_improve_page2)
        }
        val buttonImproveClose = view.findViewById<ImageButton>(R.id.close_btn)
        buttonImproveClose.setOnClickListener()
        {
            (requireActivity() as MainActivity).navigationTo(R.id.navigation_survive_the_crisis)
        }
    }

}