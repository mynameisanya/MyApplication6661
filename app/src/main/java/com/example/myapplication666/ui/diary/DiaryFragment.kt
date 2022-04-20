package com.example.myapplication666.ui.diary

import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication666.R
import com.example.myapplication666.database.App
import com.example.myapplication666.database.Model

class DiaryFragment : Fragment() {


    companion object {
        fun newInstance() = DiaryFragment()
    }
    val DiaryAdapter = DiaryAdapter()
    private var diaryList = mutableListOf<Model>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val nextBtn = view.findViewById<Button>(R.id.next_btn)
        val r = view.findViewById<RecyclerView>(R.id.recycler)
        diaryList = viewModel.getDiaryList()
        if(diaryList.isEmpty()){
            r.visibility = View.GONE
        }else{
            r.visibility = View.VISIBLE
        }
        DiaryAdapter.attachListener(object : OnChangeSeekBarListener {
            override fun onChanged(list: MutableList<Model>) {
                diaryList = list
            }

        })
        r.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        r.adapter = DiaryAdapter
        DiaryAdapter.setData(
            diaryList
        )
        nextBtn.visibility = View.VISIBLE
        nextBtn.setOnClickListener {
            startActivity(Intent(context, NewDiaryActivity::class.java))
        }
    }

    private lateinit var viewModel: DiaryViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewModel = ViewModelProvider(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return DiaryViewModel(App.returnDatabase.returnDao()) as T
            }
        }).get(DiaryViewModel::class.java)
        return inflater.inflate(R.layout.fragment_diary, container, false)
    }

    override fun onResume() {
        super.onResume()
        diaryList = viewModel.getDiaryList()
        DiaryAdapter.setData(diaryList)
    }


}