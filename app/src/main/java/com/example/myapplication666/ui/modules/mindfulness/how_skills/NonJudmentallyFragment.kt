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

class NonJudmentallyFragment : Fragment() {

    companion object {
        fun newInstance() = NonJudmentallyFragment()
    }

    private lateinit var viewModel: NonJudmentallyViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.non_judmentally_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(NonJudmentallyViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val buttonNonJudmentallyPage2 = view.findViewById<Button>(R.id.next_btn)
        buttonNonJudmentallyPage2.setOnClickListener()
        {
            (requireActivity() as MainActivity).navigationTo(R.id.navigation_non_judmentally_page2)
        }
        val buttonNonJudmentallyClose = view.findViewById<ImageButton>(R.id.close_btn)
        buttonNonJudmentallyClose.setOnClickListener()
        {
            (requireActivity() as MainActivity).popBackStack(R.id.navigation_mindfulness)
        }
    }

}