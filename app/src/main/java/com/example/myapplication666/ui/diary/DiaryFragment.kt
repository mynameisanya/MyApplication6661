package com.example.myapplication666.ui.diary

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication666.MainActivity
import com.example.myapplication666.R
import com.example.myapplication666.database.App
import com.example.myapplication666.database.DiaryModel
import com.example.myapplication666.database.Model
import com.google.android.material.floatingactionbutton.FloatingActionButton

class DiaryFragment : Fragment() {

    private val diaryAdapter = DiaryAdapter()
    private var diaryList = mutableListOf<Model>()

    private var nextBtn: FloatingActionButton? = null
    private var recyclerView: RecyclerView? = null
    private var prevArrow: ImageButton? = null
    private var nextArrow: ImageButton? = null
    private var monthTv: TextView? = null
    private var saveBtn: Button? = null

    private val viewModel by activityViewModels<DiaryViewModel> {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return DiaryViewModel(App.returnDatabase.returnDao()) as T
            }
        }
    }

    private var currentMonth = Months.APR
    //список строк
    private var months = arrayOf<String>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_diary, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews(view)

        months = resources.getStringArray(R.array.months)

        setClickListeners()
        initAdapter()

        viewModel.allDiaryLiveData.observe(viewLifecycleOwner) {
            monthTv?.text = months[currentMonth.ordinal]
            mapDiaryList()
            diaryAdapter.setData(diaryList)
        }
    }

    private fun initAdapter() {
        diaryAdapter.attachListener(object : OnChangeSeekBarListener {
            override fun onChanged(diaryList: MutableList<Model>) {
                this@DiaryFragment.diaryList = diaryList
            }
        })
        recyclerView?.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        recyclerView?.adapter = diaryAdapter
        mapDiaryList()
        diaryAdapter.setData(diaryList)
    }

    private fun setClickListeners() {
        //передвигает месяцы на следующую позицию
        nextArrow?.setOnClickListener {
            viewModel.updateList(currentMonth, diaryList)
            currentMonth = currentMonth.next()
            monthTv?.text = months[currentMonth.ordinal]
            mapDiaryList()
            diaryAdapter.setData(diaryList)
        }
        prevArrow?.setOnClickListener {
            viewModel.updateList(currentMonth, diaryList)
            currentMonth = currentMonth.prev()
            monthTv?.text = months[currentMonth.ordinal]
            mapDiaryList()
            diaryAdapter.setData(diaryList)
        }

        nextBtn?.setOnClickListener {
             val bundle = Bundle()
            bundle.putSerializable(EXTRA_NEW_DIARY, currentMonth)

            (requireActivity() as MainActivity).navigationTo(
                R.id.navigation_new_diary_fragment,
                bundle
            )
        }

        saveBtn?.setOnClickListener {
            viewModel.saveAllDiary()
            Toast.makeText(context, "Дневники были сохранены", Toast.LENGTH_SHORT).show()
        }
    }

    private fun initViews(view: View) {
        nextBtn = view.findViewById(R.id.next_btn)
        recyclerView = view.findViewById(R.id.recycler)
        prevArrow = view.findViewById(R.id.prev_month)
        nextArrow = view.findViewById(R.id.next_month)
        monthTv = view.findViewById(R.id.month_tv)
        saveBtn = view.findViewById(R.id.save_btn)
    }

    private fun mapDiaryList() {
        val diaryModel = viewModel.allDiaryLiveData.value ?: return
        if (diaryModel.data.isEmpty()) {
            return
        }
        //принимает все значения из бд
        when (monthTv?.text) {
            months[0] -> setUpdatedDiaryList(diaryModel, Months.JAN)
            months[1] -> setUpdatedDiaryList(diaryModel, Months.FEB)
            months[2] -> setUpdatedDiaryList(diaryModel, Months.MAR)
            months[3] -> setUpdatedDiaryList(diaryModel, Months.APR)
            months[4] -> setUpdatedDiaryList(diaryModel, Months.MAY)
            months[5] -> setUpdatedDiaryList(diaryModel, Months.JUN)
            months[6] -> setUpdatedDiaryList(diaryModel, Months.JUL)
            months[7] -> setUpdatedDiaryList(diaryModel, Months.AUG)
            months[8] -> setUpdatedDiaryList(diaryModel, Months.SEP)
            months[9] -> setUpdatedDiaryList(diaryModel, Months.OCT)
            months[10] -> setUpdatedDiaryList(diaryModel, Months.NOV)
            months[11] -> setUpdatedDiaryList(diaryModel, Months.DEC)
        }
    }

    private fun setUpdatedDiaryList(diaryModel: DiaryModel, month: Months) {
        val list = diaryModel.data[month]
        diaryList = list?.toMutableList() ?: mutableListOf()
    }

    override fun onDestroy() {
        super.onDestroy()
        nextBtn = null
        recyclerView = null
        prevArrow = null
        nextArrow = null
        monthTv = null
        saveBtn = null
    }

    companion object {
        fun newInstance(bundle: Bundle = Bundle()) = DiaryFragment().apply {
            arguments = bundle
        }

        const val EXTRA_NEW_DIARY = "EXTRA_NEW_DIARY"
    }
}