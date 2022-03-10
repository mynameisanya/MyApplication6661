package com.example.myapplication666.ui.diary

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication666.R

class NewDiaryFragment : Fragment() {

    companion object {
        fun newInstance() = NewDiaryFragment()
    }

    private lateinit var viewModel: NewDiaryViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.new_diary_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(NewDiaryViewModel::class.java)
        // TODO: Use the ViewModel
    }

}