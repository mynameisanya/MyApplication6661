package com.example.myapplication666.ui.modules.interpersonal_effectiveness

import androidx.recyclerview.widget.DiffUtil
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter

class ExpandableAdapter2 : ListDelegationAdapter<List<ListItem2>>() {
    private var sourceList: List<ListItem2> = emptyList()

    init {
        val expandableItemDelegate = ExpandableItemDelegate2 { item: ExpandableItem2 ->
            val newSourceList = sourceList.toMutableList()
            val itemIndex = sourceList.indexOf(item)
            newSourceList[itemIndex] = item.copy(isExpanded = !item.isExpanded)
            setItems(newSourceList)
        }
        delegatesManager.addDelegate(expandableItemDelegate)
        delegatesManager.addDelegate(InnerItemDelegate2())
    }

    override fun setItems(sourceList: List<ListItem2>?) {
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

private fun calculateDiff(oldItems: List<ListItem2>, newItems: List<ListItem2>): DiffUtil.DiffResult {
    val commonCallbackImpl = CommonCallbackImpl(
        oldItems = oldItems,
        newItems = newItems,
        areItemsTheSameImpl = { oldItem, newItem ->
            when {
                newItem is ExpandableItem2 && oldItem is ExpandableItem2 ->
                    newItem.text == oldItem.text && newItem.innerItems == oldItem.innerItems
                else -> newItem == oldItem
            }
        }
    )
    return DiffUtil.calculateDiff(commonCallbackImpl)
}

private fun List<ListItem2>.expand() = flatMap { item ->
    if (item is ExpandableItem2 && item.isExpanded)
        listOf(item) + item.innerItems
    else
        listOf(item)
}