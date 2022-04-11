package com.example.myapplication666.ui.diary

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication666.R
import com.example.myapplication666.database.App
import com.example.myapplication666.database.Model
import com.example.myapplication666.ui.diary.RecyclerTouchListener.OnRowClickListener
import com.example.myapplication666.ui.diary.RecyclerTouchListener.OnSwipeOptionsClickListener
import com.firebase.ui.auth.AuthUI.getApplicationContext
import com.google.android.material.dialog.MaterialAlertDialogBuilder


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
        val dialogView = LayoutInflater.from(context).inflate(R.layout.new_add_diary, null)
        val btnSave = dialogView.findViewById<Button>(R.id.save)
        val material = MaterialAlertDialogBuilder(requireContext()).create()
        val editTextAdd = dialogView.findViewById<EditText>(R.id.add_new_action)
        val btnAddAction = view.findViewById<Button>(R.id.showDialog)

        diaryList = viewModel.getDiaryList()

        DiaryAdapter.setData(
            diaryList
        )
        DiaryAdapter.attachListener(object : OnChangeSeekBarListener {
            override fun onChanged(list: MutableList<Model>) {
                diaryList = list
            }

        })
        r.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        r.adapter = DiaryAdapter
        val touchListener = RecyclerTouchListener(requireActivity(), r)
        touchListener
            .setClickable(object : OnRowClickListener {
                override fun onRowClicked(position: Int) {

                }

                override fun onIndependentViewClicked(independentViewID: Int, position: Int) {}
            })
            .setSwipeOptionViews(R.id.delete_task, R.id.edit_task)
            .setSwipeable(R.id.rowFG, R.id.rowBG,
                OnSwipeOptionsClickListener { viewID, position ->
                    when (viewID) {
                        R.id.delete_task -> {
                            diaryList.removeAt(position)
                            DiaryAdapter.notifyItemRemoved(position)
                            //  DiaryAdapter.removeByPosition(position)
                        }
                        R.id.edit_task -> {
                            editTextAdd.setText(diaryList[position].text)
                            btnSave.setOnClickListener {
                                val editText = editTextAdd.text.toString()
                                val model = Model(editText, 0)
                                diaryList.set(position, model)
                                DiaryAdapter.notifyItemChanged(position)
                                material.dismiss()
                            }
                            material.show()
                        }
                    }
                })
        r.addOnItemTouchListener(touchListener)

        val btnCancel = dialogView.findViewById<Button>(R.id.cancel)
        btnCancel.setOnClickListener()
        {

            material.dismiss()
        }


        material.setView(dialogView)
        btnAddAction.setOnClickListener {
            btnSave.setOnClickListener()
            {
                val editText = editTextAdd.text.toString()
                val model = Model(editText, 0)
                diaryList.add(model)
                DiaryAdapter.notifyItemInserted(diaryList.size - 1)
                material.dismiss()
            }
            material.show()
        }

        nextBtn.setOnClickListener {
            try {
                viewModel.saveData(diaryList)
            } catch (ex: IllegalStateException) {
                Toast.makeText(context, "Вы хотите сохранить пустой список", Toast.LENGTH_SHORT)
                    .show()
            }


        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewModel = ViewModelProvider(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return NewDiaryViewModel(App.returnDatabase.returnDao()) as T
            }
        }).get(NewDiaryViewModel::class.java)
        return inflater.inflate(R.layout.new_diary_fragment, container, false)
    }
}
