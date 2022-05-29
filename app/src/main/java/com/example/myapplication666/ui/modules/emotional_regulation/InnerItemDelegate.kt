package com.example.myapplication666.ui.modules.emotional_regulation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication666.R
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate

class InnerItemDelegate(private val isHideDescription:Boolean = false) :
    AbsListItemAdapterDelegate<InnerItem, ListItem, InnerItemDelegate.InnerItemViewHolder>() {

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
        item: InnerItem,
        holder: InnerItemViewHolder,
        payloads: MutableList<Any>
    ) {
        holder.questionsTv.text = item.title
        holder.answerTv.text = item.description
        if (isHideDescription) {
            holder.answerTv.visibility = View.GONE
        }
    }

    override fun isForViewType(
        item: ListItem,
        items: MutableList<ListItem>,
        position: Int
    ): Boolean {
        return item is InnerItem
    }
}