package com.example.myapplication666.ui.modules.emotional_regulation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.myapplication666.EnumER
import com.example.myapplication666.ui.modules.interpersonal_effectiveness.InterpersonalExerciseFragment
import com.example.myapplication666.ui.modules.interpersonal_effectiveness.InterpersonalTheory

class InterpersonalEffectivenessAdapter(activity: FragmentActivity): FragmentStateAdapter(activity) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when (EnumER.values()[getItemViewType(position)])
        {
            EnumER.THEORY -> InterpersonalTheory()
            EnumER.EXERCISES -> InterpersonalExerciseFragment()
        }
    }

    override fun getItemViewType(position: Int): Int {
        if (position == 0)
            return EnumER.THEORY.ordinal
        else
            return EnumER.EXERCISES.ordinal
    }

}