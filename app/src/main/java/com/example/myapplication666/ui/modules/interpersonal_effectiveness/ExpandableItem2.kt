package com.example.myapplication666.ui.modules.interpersonal_effectiveness

data class ExpandableItem2(
    var text: String,
    var isExpanded: Boolean,
    val innerItems: List<InnerItem2>
) : ListItem2
