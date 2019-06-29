package com.example.kotlinplayground.buildings

fun main() {
    Building(Wood()).build()
}

open class BaseBuildingMaterial {
    open val numberNeeded = 1
}

class Wood : BaseBuildingMaterial() {
    override val numberNeeded = 4
}

class Brick : BaseBuildingMaterial() {
    override val numberNeeded = 8
}

/**
 * Note: For this function, IntelliJ recommends not to inline the function.
 * Generally, when you create a generic function, follow the IDE's recommendation about inlining.
 */
fun <T : BaseBuildingMaterial> isSmallBuilding(building: Building<T>) {
    if (building.actualMaterialsNeeded < 500) println("Small building")
    else println("large building")
}

class Building<out T : BaseBuildingMaterial>(val buildingMaterial: T) {

    val baseMaterialsNeeded = 100
    val actualMaterialsNeeded = buildingMaterial.numberNeeded * baseMaterialsNeeded

    fun build() {
        println(" $actualMaterialsNeeded ${buildingMaterial::class.simpleName} required")
        isSmallBuilding(Building(Brick()))
    }
}