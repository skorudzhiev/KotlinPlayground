package com.example.kotlinplayground

import java.util.*

val day = currentDayUtil()

fun main() {
    println("Hello World!")

    dayOfWeek()
    greetingAmOrPm()
}

fun dayOfWeek() {
    println("What day is it today?")
    currentDayPrint()
}

fun currentDayPrint() {
    println( when (day) {
        1 -> "Sunday"
        2 -> "Monday"
        3 -> "Tuesday"
        4 -> "Wednesday"
        5 -> "Thursday"
        6 -> "Friday"
        7 -> "Saturday"
        else -> "Time has stopped"
    }
    )
}

fun greetingAmOrPm() {
    println(if (currentTimeUtil() < 12) "Good Morning" else "Good Night")
}

fun currentDayUtil(): Int {
    return Calendar.getInstance().get(Calendar.DAY_OF_WEEK)
}

fun currentTimeUtil(): Int {
    return Calendar.getInstance().get(Calendar.HOUR_OF_DAY)
}