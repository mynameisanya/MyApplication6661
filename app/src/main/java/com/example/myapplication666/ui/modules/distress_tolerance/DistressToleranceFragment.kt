package com.example.myapplication666.ui.modules.distress_tolerance

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
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
            when (DistressToleranceEnum.values()[pagerAdapter.getItemViewType(position)]) {
                DistressToleranceEnum.SURVIVE_THE_CRISIS -> tab.text = "Кризис"
                DistressToleranceEnum.ACCEPTING_REALITY -> tab.text = "Принятие"
                //DistressToleranceEnum.BEFREE -> tab.text = "Стать свободной"
                DistressToleranceEnum.ABCD -> tab.text = "АСД"
            }
        }.attach()

    }
}