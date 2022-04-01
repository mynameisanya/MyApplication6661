package com.example.myapplication666.utils//package com.example.myapplication666.utils

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.rules.RuleChain

//правила для тестирования вью модели

fun ViewModelTestingRules(): RuleChain
{
    return RuleChain.outerRule(InstantTaskExecutorRule())
}