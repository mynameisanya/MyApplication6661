package com.example.myapplication666

import android.icu.util.TimeUnit.values
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.myapplication666.ui.modules.emotional_regulation.ExercisesFragment
import com.example.myapplication666.ui.modules.emotional_regulation.FragmentTypeEnumER
import com.example.myapplication666.ui.modules.emotional_regulation.TheoryFragment
import java.time.chrono.JapaneseEra.values


class EmotionalRegulationAdapter(activity: FragmentActivity): FragmentStateAdapter(activity) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when (FragmentTypeEnumER.values()[getItemViewType(position)])
        {
            FragmentTypeEnumER.THEORY -> TheoryFragment()
            FragmentTypeEnumER.EXERCISES -> ExercisesFragment()
        }
    }

    override fun getItemViewType(position: Int): Int {
        if (position == 0)
            return FragmentTypeEnumER.THEORY.ordinal
        else
            return FragmentTypeEnumER.EXERCISES.ordinal
    }

}