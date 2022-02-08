package com.example.myapplication666

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MindFulnessFragment : Fragment() {

    private lateinit var tabLayout: TabLayout
    private lateinit var pager2: ViewPager2

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_mindfullness, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tabLayout = view.findViewById(R.id.tabLayout)
        pager2 = view.findViewById(R.id.pager2)
        val pagerAdapter = WiseMindAdapter(requireActivity())
        pager2.adapter = pagerAdapter
        TabLayoutMediator(tabLayout, pager2) { tab, position ->
            when (FragmentTypeEnum.values()[pagerAdapter.getItemViewType(position)]) {
                FragmentTypeEnum.WISEMIND -> tab.text = "Мудрое сознание"
                FragmentTypeEnum.WHATSKILLS -> tab.text = "Навыки ЧТО"
                FragmentTypeEnum.HOWSKILLS -> tab.text = "Навыки КАК"
            }

        }.attach()

    }
}