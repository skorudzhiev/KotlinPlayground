package com.example.kotlinplayground

import java.util.*


fun main() {
    println("Hello World!")
    feedTheFish()
    eagerExample()
}

fun eagerExample() {
    val decorations = listOf ("rock", "pagoda", "plastic plant", "alligator", "flowerpot")

    val eager = decorations.filter { it[0] == 'p' }
    println(eager)

    // apply filter lazily
    val filtered = decorations.asSequence().filter { it[0] == 'p' }
    println(filtered)
    println(filtered.toList())

    // apply filter lazily
    val lazyMap = decorations.asSequence().map {
        println("map: $it")
        it
    }

    println()
    println(lazyMap)
    println("first: ${lazyMap.first()}")
    println("all: ${lazyMap.toList()}")
}

/**
 * The most widely known rule for stocking a tank is the one-inch-per-fish-per-gallon-of-water rule.
 * However that's assuming the tank doesn't have any decorations in it.
 * Typically, a tank with decorations can contain a total length of fish (in inches)
 * less than or equal to 80% of the tank size (in gallons). A tank without decorations can contain a total length
 * of fish up to 100% of the tank size.
 *
 * For example:
 * A 10 gallon tank with decorations can hold up to 8 inches of fish, for example 4 x 2-inch-long fish.
 * A 20 gallon tank without decorations can hold up to 20 inches of fish, for example 6 x 1-inch-long fish and 2 x 2-inch-long fish.
 */
fun canAddFish(tankSize: Double, currentFish: List<Int>, fishSize: Int = 2, hasDecorations: Boolean = true): Boolean {
    return (tankSize * if (hasDecorations) 0.8 else 1.0) >= (currentFish.sum() + fishSize)
}

fun isTooHot(temperature: Int) = temperature > 30
fun isTooDirty(dirty: Int) = dirty > 30
fun isSunday(day: String) = day == "Sunday"

fun shouldChangeWater(day: String,
                      temperature: Int = 22,
                      dirty: Int = 20): Boolean {
    return when {
        isTooHot(temperature) -> true
        isTooDirty(dirty) -> true
        isSunday(day) -> true
        else -> false
    }
}

fun feedTheFish() {
    val day = randomDay()
    val food = fishFood(day)
    println("Today is $day and the fish eat $food")
    shouldChangeWater(day, 20, 50)

    if (shouldChangeWater(day)) println("Change the water today!")
    else println("The water's condition is still fine and can be changed another day.")

}

fun fishFood(day: String): String {
    return when (day) {
        "Monday" -> "flakes"
        "Tuesday" -> "pellets"
        "Wednesday" -> "redworms"
        "Thursday" -> "granules"
        "Friday" -> "mosquitoes"
        "Saturday" -> "lettuce"
        "Sunday" -> "plankton"
        else -> "fasting"
    }
}

fun randomDay(): String {
    val week = listOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
    return week[Random().nextInt(7)]
}
