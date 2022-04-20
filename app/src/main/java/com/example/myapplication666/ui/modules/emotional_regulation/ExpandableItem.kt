package com.example.myapplication666.ui.modules.emotional_regulation

import androidx.room.Entity

data class ExpandableItem(
    val text: String,
    val isExpanded: Boolean,
    val innerItems: List<InnerItem>
) : ListItem
