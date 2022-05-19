package com.example.myapplication666.ui.modules.emotional_regulation

data class ExpandableItem(
    var text: String,
    var isExpanded: Boolean,
    val innerItems: List<InnerItem>
) : ListItem
