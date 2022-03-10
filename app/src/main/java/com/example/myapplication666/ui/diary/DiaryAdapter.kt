package com.example.myapplication666.ui.diary

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication666.R

class DiaryAdapter: RecyclerView.Adapter<DiaryAdapter.NewDiaryVewHolder>() {

    var list = listOf<String>()
    inner class NewDiaryVewHolder(private val itemView: View): RecyclerView.ViewHolder(itemView) {

       val textView = itemView.findViewById<TextView>(R.id.text)
        fun bind(position: Int)
        {
            textView.text = list[position]
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewDiaryVewHolder {
        val param = LayoutInflater.from(parent.context).inflate(R.layout.item_new_diary, parent, false)
        return NewDiaryVewHolder(param)
    }

    override fun onBindViewHolder(holder: NewDiaryVewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun setData(list: List<String>)
    {
        this.list = list
    }

}