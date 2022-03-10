package com.example.myapplication666.distress_tolerance;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.example.myapplication666.BeFreeFragment
import com.example.myapplication666.survive_the_crisis.SurviveTheCrisisFragment;
import com.example.myapplication666.accepting_reality.AcceptingRealityFragment;
import com.example.myapplication666.dcba.DCBAFragment


class DistressToleranceAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {
    override fun getItemCount(): Int {
        return 4
    }

    override fun createFragment(position: Int): Fragment {
        return when (DistressToleranceEnum.values()[getItemViewType(position)]) {
            DistressToleranceEnum.SURVIVE_THE_CRISIS -> SurviveTheCrisisFragment()
            DistressToleranceEnum.ACCEPTING_REALITY -> AcceptingRealityFragment()
            DistressToleranceEnum.BEFREE -> BeFreeFragment()
            DistressToleranceEnum.ABCD -> DCBAFragment()
        }
    }

    override fun getItemViewType(position: Int): Int {
        if (position == 0)
            return DistressToleranceEnum.SURVIVE_THE_CRISIS.ordinal
        if (position == 1)
            return DistressToleranceEnum.ACCEPTING_REALITY.ordinal
        if (position == 2) {
            return DistressToleranceEnum.BEFREE.ordinal
        } else
            return DistressToleranceEnum.ABCD.ordinal
    }
}
