package com.example.myapplication666

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.myapplication666.ui.modules.how_skills.HOWSkillsFragment
import com.example.myapplication666.ui.modules.what_skills.WHATSkillsFragment
import com.example.myapplication666.ui.modules.wise_mind.WiseMindFragment

class MindfulnessAdapter(activity: FragmentActivity): FragmentStateAdapter(activity) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when (FragmentTypeEnum.values()[getItemViewType(position)])
        {
            FragmentTypeEnum.WISEMIND -> WiseMindFragment()
            FragmentTypeEnum.WHATSKILLS -> WHATSkillsFragment()
            FragmentTypeEnum.HOWSKILLS -> HOWSkillsFragment()
        }
    }

    override fun getItemViewType(position: Int): Int {
        if (position == 0)
            return FragmentTypeEnum.WISEMIND.ordinal
        if (position == 1)
            return FragmentTypeEnum.WHATSKILLS.ordinal
        else
            return FragmentTypeEnum.HOWSKILLS.ordinal
    }

}