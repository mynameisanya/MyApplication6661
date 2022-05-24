package com.example.myapplication666.ui.modules.interpersonal_effectiveness

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication666.R
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate

class InnerItemDelegate2 :
    AbsListItemAdapterDelegate<InnerItem2, ListItem2, InnerItemDelegate2.InnerItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup): InnerItemViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_inner, parent, false)
        return InnerItemViewHolder(view)
    }

    inner class InnerItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val questionsTv: TextView = itemView.findViewById(R.id.question_tv)
        val answerTv: TextView = itemView.findViewById(R.id.answer_tv)
    }

    override fun onBindViewHolder(
        item: InnerItem2,
        holder: InnerItemViewHolder,
        payloads: MutableList<Any>
    ) {
        holder.questionsTv.text = item.title
        holder.answerTv.text = item.description
    }

    override fun isForViewType(
        item: ListItem2,
        items: MutableList<ListItem2>,
        position: Int
    ): Boolean {
        return item is InnerItem2
    }
}