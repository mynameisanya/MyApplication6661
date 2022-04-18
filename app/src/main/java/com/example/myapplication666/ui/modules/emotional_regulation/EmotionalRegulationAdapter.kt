package com.example.myapplication666


import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.myapplication666.ui.modules.emotional_regulation.ExercisesFragment
import com.example.myapplication666.ui.modules.emotional_regulation.TheoryFragment


class EmotionalRegulationAdapter(activity: FragmentActivity): FragmentStateAdapter(activity) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when (EnumER.values()[getItemViewType(position)])
        {
            EnumER.THEORY -> TheoryFragment()
            EnumER.EXERCISES -> ExercisesFragment()
        }
    }

    override fun getItemViewType(position: Int): Int {
        if (position == 0)
            return EnumER.THEORY.ordinal
        else
            return EnumER.EXERCISES.ordinal
    }

}