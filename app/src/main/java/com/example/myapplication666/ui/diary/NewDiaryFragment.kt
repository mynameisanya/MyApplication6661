package com.example.myapplication666.ui.diary

import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication666.NewActionDiary
import com.example.myapplication666.R
import com.example.myapplication666.database.Model

class NewDiaryFragment : Fragment() {

    companion object {
        fun newInstance() = NewDiaryFragment()
    }

    private lateinit var viewModel: NewDiaryViewModel

    val DiaryAdapter = DiaryAdapter()
    private var diaryList = mutableListOf<Model>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val r = view.findViewById<RecyclerView>(R.id.recycler)
        val nextBtn = view.findViewById<Button>(R.id.next_btn)
        diaryList = viewModel.getDiaryList()


        DiaryAdapter.setData(
            diaryList
        )
        DiaryAdapter.attachListener(object :OnChangeSeekBarListener{
            override fun onChanged(list: MutableList<Model>) {
                diaryList = list
            }

        })
        r.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        r.adapter = DiaryAdapter

        val newAddAction = view.findViewById<Button>(R.id.new_add_action)
        newAddAction.setOnClickListener {
            val intent = Intent (context, NewActionDiary::class.java)
            intent.putParcelableArrayListExtra("New diary", ArrayList(diaryList))
            startActivity(intent)
        }

        nextBtn.setOnClickListener {
            viewModel.saveData(
                diaryList
            )


        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewModel = ViewModelProvider(this).get(NewDiaryViewModel::class.java)
        return inflater.inflate(R.layout.new_diary_fragment, container, false)
    }


}