package com.example.myapplication666.ui.diary

enum class Months {
    JAN, FEB, MAR, APR, MAY, JUN, JUL, AUG, SEP, OCT, NOV, DEC;
}

private val vals: Array<Months> = Months.values()

fun Months.next(): Months {
    return vals[(ordinal + 1) % vals.size]
}

fun Months.prev(): Months {
    if (ordinal == 0) {
        return Months.DEC
    }
    return vals[(ordinal - 1) % vals.size]
}