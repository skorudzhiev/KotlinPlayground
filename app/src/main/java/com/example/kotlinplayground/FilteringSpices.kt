package com.example.kotlinplayground

fun main() {
    filteringSpices()
}

fun filteringSpices() {
    val spices = listOf("curry", "pepper", "cayenne", "ginger", "red curry", "green curry", "red pepper" )
    println("List of Spices: $spices")

    println()
    println("Sorting curries by string length")
    println(spices.filter {it.contains("curry")}.sortedBy { it.length })

    println()
    println("Filtering by those that start with 'c' and end with 'e'")
    println(spices.filter {it.startsWith('c')}.filter {it.endsWith('e')})

    println()
    println("or")
    println(spices.filter {it.startsWith('c') && it.endsWith('e')})

    println()
    println("Filtering the first 3 items by 'c'")
    println(spices.take(3).filter{it.startsWith('c')})
}