package com.example.myapplication666.ui.diary

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication666.R
import com.example.myapplication666.database.Model

class DiaryFragment : Fragment() {


    companion object {
        fun newInstance() = DiaryFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val nextBtn = view.findViewById<Button>(R.id.next_btn)
        nextBtn.visibility = View.VISIBLE
        nextBtn.setOnClickListener {
            childFragmentManager.beginTransaction()
                .add(R.id.container, NewDiaryFragment.newInstance()).addToBackStack(null).commit()
                nextBtn.visibility = View.GONE
        }
    }

    private lateinit var viewModel: DiaryViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_diary, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(DiaryViewModel::class.java)
        // TODO: Use the ViewModel
    }

}