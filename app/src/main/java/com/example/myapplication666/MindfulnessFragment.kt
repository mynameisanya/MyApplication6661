package com.example.myapplication666

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MindfulnessFragment : Fragment() {

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
        val imageButton = view.findViewById<ImageButton>(R.id.rational_mind_image)
        val pagerAdapter = MindfulnessAdapter(requireActivity())
        pager2.adapter = pagerAdapter
        TabLayoutMediator(tabLayout, pager2) { tab, position ->
            when (FragmentTypeEnum.values()[pagerAdapter.getItemViewType(position)]) {
                FragmentTypeEnum.WISEMIND -> tab.text = getString(R.string.wise_mind_tab_text)
                FragmentTypeEnum.WHATSKILLS -> tab.text = getString(R.string.what_skils_tab_text)
                FragmentTypeEnum.HOWSKILLS -> tab.text = getString(R.string.how_skils_tab_text)
            }

        }.attach()

    }
}