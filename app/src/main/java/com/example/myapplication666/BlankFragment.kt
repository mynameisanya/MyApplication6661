package com.example.myapplication666

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout

class BlankFragment : Fragment() {



    private lateinit var viewModel: BlankViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.blank_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val tabLayout = view.findViewById<TabLayout>(R.id.tabLayout)
        val pager2 = view.findViewById<ViewPager2>(R.id.pager2)
    }

    companion object {
        fun newInstance(bundle: Bundle) : BlankFragment
        {
           val blankFragment = BlankFragment()
            blankFragment.arguments = bundle
            return blankFragment
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(BlankViewModel::class.java)
        // TODO: Use the ViewModel
    }

}