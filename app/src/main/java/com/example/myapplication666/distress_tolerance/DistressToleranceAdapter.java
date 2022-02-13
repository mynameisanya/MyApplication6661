package com.example.myapplication666.distress_tolerance;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.example.myapplication666.FragmentTypeEnum;
import com.example.myapplication666.survive_the_crisis.SurviveTheCrisisFragment;
import com.example.myapplication666.accepting_reality.AcceptingRealityFragment;


    class DistressToleranceAdapter(activity: FragmentActivity): FragmentStateAdapter(activity)
        {
        override fun getItemCount(): Int {
            return 2
        }

        override fun createFragment(position: Int): Fragment {
            return when (FragmentTypeEnum.values()[getItemViewType(position)])
            {
                Enum2. -> WiseMindFragment()
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
}
