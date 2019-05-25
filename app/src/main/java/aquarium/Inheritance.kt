package aquarium

fun main() {
    delegate()
}

fun delegate() {
    val pleco = Plecostomus()
    println("Fish has color ${pleco.color}")
    pleco.eat()
}

/**
 * Use an interface if you have a lot of methods and
 * one or two default implementations, like this
 */
interface AquariumAction {
    fun eat()
    fun jump()
    fun clean()
    fun catchFish()
    fun swim() {
        println("swim")
    }
}

/**
 * Use an abstract class anytime you can't complete a class
 */
abstract class AquarumiumFish: FishAction {
    override fun eat() = print("Yum")
}

interface FishColor {
    val color: String
}

object GoldColor: FishColor {
    override val color = "gold"
}

object RedColor: FishColor {
    override val color = "red"
}

class PrintingFishAction(val food: String): FishAction {
    override fun eat() {
        println("and eats $food")
    }
}

class Plecostomus(fishColor: FishColor = GoldColor):
    FishAction by PrintingFishAction("a lot of algae"),
        FishColor by fishColor

