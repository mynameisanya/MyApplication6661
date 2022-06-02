package com.example.myapplication666.ui.diary

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication666.MainActivity
import com.example.myapplication666.R
import com.example.myapplication666.database.App
import com.example.myapplication666.database.Model
import com.example.myapplication666.ui.modules.emotional_regulation.ExpandableAdapter
import com.example.myapplication666.ui.modules.emotional_regulation.ExpandableItem
import com.example.myapplication666.ui.modules.emotional_regulation.InnerItem
import com.example.myapplication666.ui.modules.emotional_regulation.ListItem
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.floatingactionbutton.FloatingActionButton

class NewDiaryFragment : Fragment() {

    private var recycler: RecyclerView? = null
    private var expandableList: RecyclerView? = null
    private var saveBtn: Button? = null
    private var dialogView: View? = null
    private var btnSave: Button? = null
    private var editTextAdd: EditText? = null
    private var btnAddAction: FloatingActionButton? = null
    private var btnCancel: Button? = null
    private lateinit var alertDialog: AlertDialog

    val diaryAdapter = DiaryAdapter()
    private val expandableAdapter = ExpandableAdapter(true)
    private var diaryList = mutableListOf<Model>()

    private var currentMonth = Months.APR

    //вью модель для обмена данными между фрагментами нью дайри и дайри
    private val viewModel by activityViewModels<DiaryViewModel> {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return DiaryViewModel(App.returnDatabase.returnDao()) as T
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.new_diary_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews(view)
        buildAlertDialog()
        initAdapter()
        setClickListeners()

        expandableList?.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        setData()
       expandableList?.adapter = expandableAdapter
        currentMonth = arguments?.get(DiaryFragment.EXTRA_NEW_DIARY) as Months
        diaryList = viewModel.getDefaultDiaryList()
        diaryAdapter.setData(diaryList)
    }

    private fun setData() {

        val mutableList = mutableListOf<ListItem>()

        val innerItems = mutableListOf<InnerItem>()

        innerItems.add(InnerItem("1 - Не думала, не использовала", ""))
        innerItems.add(InnerItem("2 - Думала, не использовала, не пыталась", ""))
        innerItems.add(InnerItem("3 - Думала, не использовала, пыталась", ""))
        innerItems.add(InnerItem("4 - Пыталась, но не смогла использовать", ""))
        innerItems.add(InnerItem("5 - Использовала, но не помогло", ""))
        innerItems.add(InnerItem("6 - Использовала, помогло", ""))
        mutableList.add(
            ExpandableItem(
                "Использование навыков",
                false,
                innerItems
            )
        )


            expandableAdapter.items = mutableList
    }

    private fun setClickListeners() {
        btnCancel?.setOnClickListener()
        {
            alertDialog.dismiss()
        }

        btnAddAction?.setOnClickListener {
            btnSave?.setOnClickListener()
            {
                val editText = editTextAdd?.text.toString()
                val model = Model(editText, 0)
                diaryList.add(model)
                diaryAdapter.notifyItemInserted(diaryList.size - 1)
                alertDialog.dismiss()
            }
            alertDialog.show()
        }

        saveBtn?.setOnClickListener {
            Log.e(javaClass.simpleName, "saveBtn")
            try {
                val listToSave = mutableListOf<Model>()
                diaryList.forEach {
                    if (it.characteristic != 0)
                        listToSave.add(it)
                }
                viewModel.saveData(currentMonth, listToSave)
                (requireActivity() as MainActivity).popBackStack()
            } catch (ex: IllegalStateException) {
                Toast.makeText(context, "Вы хотите сохранить пустой список", Toast.LENGTH_SHORT)
                    .show()

            }
        }
    }

    private fun buildAlertDialog() {
        alertDialog = MaterialAlertDialogBuilder(requireContext()).create()
        dialogView = LayoutInflater.from(context).inflate(R.layout.new_add_diary, null)
        btnSave = dialogView?.findViewById(R.id.save)
        editTextAdd = dialogView?.findViewById(R.id.add_new_action)
        btnCancel = dialogView?.findViewById(R.id.cancel)
        alertDialog.setView(dialogView)
    }

    private fun initAdapter() {
        diaryAdapter.setData(diaryList)
        diaryAdapter.attachListener(object : OnChangeSeekBarListener {
            override fun onChanged(list: MutableList<Model>) {
                diaryList = list
            }

        })

        recycler?.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        recycler?.adapter = diaryAdapter
        val touchListener = RecyclerTouchListener(activity, recycler)
        touchListener.setClickable(object : RecyclerTouchListener.OnRowClickListener {
            override fun onRowClicked(position: Int) {}
            override fun onIndependentViewClicked(independentViewID: Int, position: Int) {}
        })
            .setSwipeOptionViews(R.id.delete_task, R.id.edit_task)
            .setSwipeable(R.id.rowFG, R.id.rowBG) { viewID, position ->
                when (viewID) {
                    R.id.delete_task -> {
                        diaryList.removeAt(position)
                        diaryAdapter.notifyItemRemoved(position)
                        //  DiaryAdapter.removeByPosition(position)
                    }
                    R.id.edit_task -> {
                        editTextAdd?.setText(diaryList[position].text)
                        btnSave?.setOnClickListener {
                            val editText = editTextAdd?.text.toString()
                            val model = Model(editText, 0)
                            diaryList[position] = model
                            diaryAdapter.notifyItemChanged(position)
                            alertDialog.dismiss()
                        }
                        alertDialog.show()
                    }
                }
            }
        recycler?.addOnItemTouchListener(touchListener)
    }

    private fun initViews(view: View) {
        recycler = view.findViewById(R.id.recycler)
        saveBtn = view.findViewById(R.id.save_btn)
        btnAddAction = view.findViewById(R.id.showDialog)
        expandableList = view.findViewById(R.id.expandable_list)
    }

    override fun onDestroy() {
        super.onDestroy()
        recycler = null
        saveBtn = null
        dialogView = null
        btnSave = null
        editTextAdd = null
        btnAddAction = null
        btnCancel = null
    }

    companion object {
        fun newInstance(bundle: Bundle = Bundle()) = NewDiaryFragment().apply {
            arguments = bundle
        }
    }
}