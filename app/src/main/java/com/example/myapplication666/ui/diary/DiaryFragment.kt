package com.example.myapplication666.ui.diary

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication666.R

class DiaryFragment : Fragment() {

    val DiaryAdapter = DiaryAdapter()

    companion object {
        fun newInstance() = DiaryFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val r = view.findViewById<RecyclerView>(R.id.recycler)
        DiaryAdapter.setData(listOf("One", "Two", "Three"))
        r.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        r.adapter = DiaryAdapter
    }

    private lateinit var viewModel: DiaryViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.new_diary_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(DiaryViewModel::class.java)
        // TODO: Use the ViewModel
    }

}