package com.example.myapplication666.ui.diary

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication666.R
import com.example.myapplication666.database.App
import com.example.myapplication666.database.Model
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.floatingactionbutton.FloatingActionButton

class NewDiaryActivity : AppCompatActivity() {

    private lateinit var viewModel: NewDiaryViewModel

    val DiaryAdapter = DiaryAdapter()
    private var diaryList = mutableListOf<Model>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return NewDiaryViewModel(App.returnDatabase.returnDao()) as T
            }
        }).get(NewDiaryViewModel::class.java)
        setContentView(R.layout.new_diary_fragment)
        val r = findViewById<RecyclerView>(R.id.recycler)
        val nextBtn = findViewById<Button>(R.id.next_btn)
        val dialogView = LayoutInflater.from(this).inflate(R.layout.new_add_diary, null)
        val btnSave = dialogView.findViewById<Button>(R.id.save)
        val material = MaterialAlertDialogBuilder(this).create()
        val editTextAdd = dialogView.findViewById<EditText>(R.id.add_new_action)
        val btnAddAction = findViewById<FloatingActionButton>(R.id.showDialog)

        diaryList = viewModel.getDiaryList()

        DiaryAdapter.setData(
            diaryList
        )
        DiaryAdapter.attachListener(object : OnChangeSeekBarListener {
            override fun onChanged(list: MutableList<Model>) {
                diaryList = list
            }

        })
        r.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        r.adapter = DiaryAdapter
        val touchListener = RecyclerTouchListener(this, r)
        touchListener
            .setClickable(object : RecyclerTouchListener.OnRowClickListener {
                override fun onRowClicked(position: Int) {

                }

                override fun onIndependentViewClicked(independentViewID: Int, position: Int) {}
            })
            .setSwipeOptionViews(R.id.delete_task, R.id.edit_task)
            .setSwipeable(
                R.id.rowFG, R.id.rowBG,
                RecyclerTouchListener.OnSwipeOptionsClickListener { viewID, position ->
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
                finish()
            } catch (ex: IllegalStateException) {
                Toast.makeText(this, "Вы хотите сохранить пустой список", Toast.LENGTH_SHORT)
                    .show()
            }


        }

    }

}