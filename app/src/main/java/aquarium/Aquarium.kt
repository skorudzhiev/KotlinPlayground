package aquarium

import kotlin.math.PI

open class Aquarium(var length: Int = 100, var width: Int = 20, var height: Int = 40) {

    open var volume: Int
    get() = width * height * length / 1000
    set(value) {height = (value * 1000) / (width * length)}

    /**
     * Just like classes, members are not available for subclassing by default.
     * This is so we don't accidentally leak implementation details without meaning to.
     */
    // Changeable variable water and set it to 90% of the volume
    open var water = volume * 0.9

    // Returns an aquarium size based on the number of fish
    constructor(numberOfFish: Int): this() {

        val water: Int = numberOfFish * 2000 // cm3
        val tank: Double = water + water * 0.1
        height = (tank / (length * width)).toInt()
    }
}

class TowerTank(): Aquarium() {

    override var water = volume * 0.8

    override var volume: Int
    get() = (width * height * length / 1000 * PI).toInt()
    set(value) {
        height = (value * 1000) / (width * length)}
}