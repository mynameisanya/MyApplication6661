package com.example.myapplication666.ui.modules.interpersonal_effectiveness

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.myapplication666.EnumER
import com.example.myapplication666.R
import com.example.myapplication666.ui.modules.emotional_regulation.InterpersonalEffectivenessAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class InterpersonalEffectiveness : Fragment() {

    private lateinit var tabLayout: TabLayout
    private lateinit var pager2: ViewPager2

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.interpersonal_effectiveness_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tabLayout = view.findViewById(R.id.tabLayout)
        pager2 = view.findViewById(R.id.pager2)
        val pagerAdapter =
            InterpersonalEffectivenessAdapter(
                requireActivity()
            )
        pager2.adapter = pagerAdapter
        TabLayoutMediator(tabLayout, pager2) { tab, position ->
            when (EnumER.values()[pagerAdapter.getItemViewType(position)]) {
                EnumER.THEORY -> tab.text = "Теория"
                EnumER.EXERCISES -> tab.text = "Упражнения"
            }

        }.attach()

    }
}