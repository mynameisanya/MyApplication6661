package com.example.myapplication666.ui.modules.emotional_regulation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.ViewCompat.animate
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication666.R
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate

class ExpandableItemDelegate(private val clickCallback: (expandableItem: ExpandableItem) -> Unit) :
    AbsListItemAdapterDelegate<ExpandableItem, ListItem, ExpandableItemDelegate.ExpandableItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup): ExpandableItemViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_expandable, parent, false)
        return ExpandableItemViewHolder(view)
    }

    inner class ExpandableItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val headerText = itemView.findViewById<TextView>(R.id.header_text)
        val icon = itemView.findViewById<ImageView>(R.id.icon)
        val animation = animate(icon)
    }

    override fun onBindViewHolder(
        item: ExpandableItem,
        holder: ExpandableItemViewHolder,
        payloads: MutableList<Any>
    ) {
        holder.headerText.text = item.text

        holder.animation.cancel()
        if (payloads.isNotEmpty()) {
            holder.animation.rotation(if (item.isExpanded) 180f else 0f).start()
        } else {
            holder.icon.rotation = if (item.isExpanded) 180f else 0f
        }
        holder.itemView.setOnClickListener {
            clickCallback(item)
        }
    }

    override fun isForViewType(
        item: ListItem,
        items: MutableList<ListItem>,
        position: Int
    ): Boolean {
        return item is ExpandableItem
    }
}