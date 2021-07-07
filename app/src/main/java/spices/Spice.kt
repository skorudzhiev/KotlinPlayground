package spices

class Spice(val name: String, val spiciness: String = "mild") {

    private val heat: Int
    get() {
        return when (spiciness) {
            "mild" -> 1
            "medium" -> 2
            "spicy" -> 5
            "very spicy" -> 7
            "extremely spicy" -> 10
            else -> 0
        }
    }

    val spices1 = listOf(
        Spice("curry", "mild"),
        Spice("pepper", "medium"),
        Spice("cayenne", "spicy"),
        Spice("ginger", "mild"),
        Spice("red curry", "medium"),
        Spice("green curry", "mild"),
        Spice("hot pepper", "extremely spicy")
    )

    val spice = Spice("cayenne", "spicy")

    val spiceList = spices1.filter { it.heat < 5 }

    fun makeSalt() = Spice("salt")


}