package com.example.myapplication666.ui.modules.emotional_regulation

import androidx.recyclerview.widget.DiffUtil
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter

class ExpandableAdapter : ListDelegationAdapter<List<ListItem>>() {
    private var sourceList: List<ListItem> = emptyList()

    init {
        val expandableItemDelegate = ExpandableItemDelegate { item: ExpandableItem ->
            val newSourceList = sourceList.toMutableList()
            val itemIndex = sourceList.indexOf(item)
            newSourceList[itemIndex] = item.copy(isExpanded = !item.isExpanded)
            setItems(newSourceList)
        }
        delegatesManager.addDelegate(expandableItemDelegate)
        delegatesManager.addDelegate(InnerItemDelegate())
    }

    override fun setItems(sourceList: List<ListItem>?) {
        this.sourceList = sourceList ?: emptyList()
        val oldItems = items ?: emptyList()
        val newItems = sourceList!!.expand()
        val diffResult: DiffUtil.DiffResult = calculateDiff(oldItems, newItems)
        diffResult.dispatchUpdatesTo(this)
        super.setItems(newItems)
    }
}

class CommonCallbackImpl<T>(
    private val oldItems: List<T>,
    private val newItems: List<T>,
    private val areItemsTheSameImpl: (oldItem: T, newItem: T) -> Boolean = { oldItem, newItem -> oldItem == newItem },
    private val areContentsTheSameImpl: (oldItem: T, newItem: T) -> Boolean = { oldItem, newItem -> oldItem == newItem },
    private val getChangePayloadImpl: (oldItem: T, newItem: T) -> Any? = { _, _ -> Any() }

) : DiffUtil.Callback() {
    override fun getOldListSize(): Int = oldItems.size

    override fun getNewListSize(): Int = newItems.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldItem = oldItems[oldItemPosition]
        val newItem = newItems[newItemPosition]
        return areItemsTheSameImpl(oldItem, newItem)
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldItem = oldItems[oldItemPosition]
        val newItem = newItems[newItemPosition]
        return areContentsTheSameImpl(oldItem, newItem)
    }

    override fun getChangePayload(oldItemPosition: Int, newItemPosition: Int): Any? {
        val oldItem = oldItems[oldItemPosition]
        val newItem = newItems[newItemPosition]
        return getChangePayloadImpl(oldItem, newItem)
    }
}

private fun calculateDiff(oldItems: List<ListItem>, newItems: List<ListItem>): DiffUtil.DiffResult {
    val commonCallbackImpl = CommonCallbackImpl(
        oldItems = oldItems,
        newItems = newItems,
        areItemsTheSameImpl = { oldItem, newItem ->
            when {
                newItem is ExpandableItem && oldItem is ExpandableItem ->
                    newItem.text == oldItem.text && newItem.innerItems == oldItem.innerItems
                else -> newItem == oldItem
            }
        }
    )
    return DiffUtil.calculateDiff(commonCallbackImpl)
}

private fun List<ListItem>.expand() = flatMap { item ->
    if (item is ExpandableItem && item.isExpanded)
        listOf(item) + item.innerItems
    else
        listOf(item)
}