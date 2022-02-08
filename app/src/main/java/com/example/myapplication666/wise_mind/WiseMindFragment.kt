package com.example.myapplication666.wise_mind

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.myapplication666.FragmentTypeEnum
import com.example.myapplication666.R
import com.example.myapplication666.WiseMindAdapter
import com.example.myapplication666.how_skills.HOWSkillsFragment
import com.example.myapplication666.what_skills.WHATSkillsFragment
import com.example.myapplication666.what_skills.WHATSkillsViewModel
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class WiseMindFragment : Fragment() {

    companion object {
        fun newInstance() = WiseMindFragment()
    }

    private lateinit var viewModel: WHATSkillsViewModel

    private lateinit var tabLayout: TabLayout
    private lateinit var pager2: ViewPager2

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.wise_mind_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(WHATSkillsViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tabLayout = view.findViewById(R.id.tabLayout)
        pager2 = view.findViewById(R.id.pager2)
        val pagerAdapter = WiseMindAdapter(requireActivity())
        pager2.adapter = pagerAdapter
        TabLayoutMediator(tabLayout, pager2) {tab, position ->
             when (FragmentTypeEnum.values()[pagerAdapter.getItemViewType(position)])
            {
                FragmentTypeEnum.WISEMIND -> tab.text = "Мудрое сознание"
                FragmentTypeEnum.WHATSKILLS -> tab.text = "Навыки ЧТО"
                FragmentTypeEnum.HOWSKILLS -> tab.text = "Навыки КАК"
            }

        }.attach()

    }



}