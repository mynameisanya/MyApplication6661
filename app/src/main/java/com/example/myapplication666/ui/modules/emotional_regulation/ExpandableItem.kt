package com.example.myapplication666.ui.modules.emotional_regulation

data class ExpandableItem(
    val text: String,
    val isExpanded: Boolean,
    val innerItems: List<InnerItem>
) : ListItem
