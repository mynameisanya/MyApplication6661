package com.example.myapplication666.ui.diary

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication666.R
import com.example.myapplication666.database.App
import com.example.myapplication666.database.Model

class DiaryFragment : Fragment() {

    val DiaryAdapter = DiaryAdapter()
    private var diaryList = mutableListOf<Model>()

    private lateinit var viewModel: DiaryViewModel

    private var currentMonth = 3
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return DiaryViewModel(App.returnDatabase.returnDao()) as T
            }
        })[DiaryViewModel::class.java]
        return inflater.inflate(R.layout.fragment_diary, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val nextBtn = view.findViewById<Button>(R.id.next_btn)
        val r = view.findViewById<RecyclerView>(R.id.recycler)
        val prevArrow = view.findViewById<ImageButton>(R.id.prev_month)
        val nextArrow = view.findViewById<ImageButton>(R.id.next_month)
        val monthTv = view.findViewById<TextView>(R.id.month_tv)
        val months = resources.getStringArray(R.array.months)
        nextArrow.setOnClickListener {
            currentMonth++
            if(currentMonth==12){
                currentMonth = 0
            }
            monthTv.text = months[currentMonth]
        }
        prevArrow.setOnClickListener {
            currentMonth--
            if (currentMonth == -1) {
                currentMonth = 11
            }
            monthTv.text = months[currentMonth]
        }
        diaryList = viewModel.getDiaryList()
        if (diaryList.isEmpty()) {
            r.visibility = View.GONE
        } else {
            r.visibility = View.VISIBLE
        }
        DiaryAdapter.attachListener(object : OnChangeSeekBarListener {
            override fun onChanged(diaryList: MutableList<Model>) {
                this@DiaryFragment.diaryList = diaryList
            }

        })
        r.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        r.adapter = DiaryAdapter
        DiaryAdapter.setData(
            diaryList
        )
        nextBtn.visibility = View.VISIBLE
        nextBtn.setOnClickListener {
            val intent = Intent(context, NewDiaryActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        diaryList = viewModel.getDiaryList()
        DiaryAdapter.setData(diaryList)
    }

    companion object {
        fun newInstance() = DiaryFragment()
    }
}