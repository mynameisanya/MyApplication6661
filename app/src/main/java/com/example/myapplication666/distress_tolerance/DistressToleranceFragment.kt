package com.example.myapplication666.distress_tolerance

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.myapplication666.Enum2
import com.example.myapplication666.R
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class DistressToleranceFragment : Fragment() {

    private lateinit var tabLayout: TabLayout
    private lateinit var pager2: ViewPager2

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.distress_tolerance_fragment, container, false)
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tabLayout = view.findViewById(R.id.tabLayout)
        pager2 = view.findViewById(R.id.pager2)
        val pagerAdapter = DistressToleranceAdapter(requireActivity())
        pager2.adapter = pagerAdapter
        TabLayoutMediator(tabLayout, pager2) { tab, position ->
            when (Enum2.values()[pagerAdapter.getItemViewType(position)]) {
                Enum2.SURVIVE_THE_CRISIS -> tab.text = "Выживание в кризисе"
                Enum2.ACCEPTING_REALITY -> tab.text = "Принятие реальности"
                Enum2.BEFREE -> tab.text = "Стать свободной"
                Enum2.ABCD -> tab.text = "ABCD"
            }

        }.attach()

    }
}