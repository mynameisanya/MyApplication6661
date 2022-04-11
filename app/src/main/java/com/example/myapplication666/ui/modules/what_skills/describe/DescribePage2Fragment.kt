package com.example.myapplication666.ui.modules.what_skills.describe

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.myapplication666.MainActivity
import com.example.myapplication666.R

class DescribePage2Fragment : Fragment() {

    companion object {
        fun newInstance() = DescribePage2Fragment()
    }

    private lateinit var viewModel: DescribePage2ViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.describe_page2_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(DescribePage2ViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val buttonDescribePage3 = view.findViewById<Button>(R.id.next_btn)
        buttonDescribePage3.setOnClickListener()
        {
            (requireActivity() as MainActivity).navigationTo(R.id.navigation_describe_page3)
        }
    }

}