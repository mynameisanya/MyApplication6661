package com.example.myapplication666.ui.modules.what_skills.describe

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

class DescribePage3Fragment : Fragment() {

    companion object {
        fun newInstance() = DescribePage3Fragment()
    }

    private lateinit var viewModel: DescribePage3ViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.describe_page3_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(DescribePage3ViewModel::class.java)
        // TODO: Use the ViewModel
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val buttonDescribeBack = view.findViewById<Button>(R.id.back_btn)
        buttonDescribeBack.setOnClickListener()
        {
            (requireActivity() as MainActivity).navigationTo(R.id.navigation_describe_page2)
        }
        val buttonDescribeClose = view.findViewById<ImageButton>(R.id.close_btn)
        buttonDescribeClose.setOnClickListener()
        {
            (requireActivity() as MainActivity).navigationTo(R.id.navigation_what_skills)
        }
    }
}