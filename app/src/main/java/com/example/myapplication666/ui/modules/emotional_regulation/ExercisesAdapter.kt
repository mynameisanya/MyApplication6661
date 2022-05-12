package com.example.myapplication666.ui.modules.emotional_regulation

import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.SeekBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication666.R
import com.example.myapplication666.database.Model

class ExercisesAdapter : RecyclerView.Adapter<ExercisesAdapter.ExercisesViewHolder>(){
    var list = mutableListOf<Pair<String, String>>()

    fun setData(list:List<Pair<String, String>>){
        this.list.addAll(list)
    }
    inner class ExercisesViewHolder(private val itemView: View) : RecyclerView.ViewHolder(itemView) {

        val textView = itemView.findViewById<TextView>(R.id.textView)
        val editText = itemView.findViewById<EditText>(R.id.editText)
        fun bind(position: Int){
            val currentItem = list[position]
            textView.text = list[position].first
            editText.addTextChangedListener(object: TextWatcher{
                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    list[position] = Pair(list[position].first, s.toString())

                }

                override fun afterTextChanged(s: Editable?) {
                }

            })
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExercisesViewHolder {
        val param =
            LayoutInflater.from(parent.context).inflate(R.layout.item_exercise, parent, false)
        return ExercisesViewHolder(param)
    }




    override fun onBindViewHolder(holder: ExercisesViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return list.size
    }

}