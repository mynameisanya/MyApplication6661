package com.example.myapplication666.what_skills.describe

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.myapplication666.MainActivity
import com.example.myapplication666.R

class DescribeFragment : Fragment() {

    companion object {
        fun newInstance() = DescribeFragment()
    }

    private lateinit var viewModel: DescribeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.describe_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(DescribeViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val buttonDescribePage2 = view.findViewById<Button>(R.id.next_btn)
        buttonDescribePage2.setOnClickListener()
        {
            (requireActivity() as MainActivity).navigationTo(R.id.navigation_describe_page2)
        }
    }

}