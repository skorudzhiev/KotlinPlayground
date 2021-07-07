package spices


fun main() {
    presentSpiceCabinet()
}

data class SpiceContainer(var spice: Curry) {
    val label = spice.name
}

fun presentSpiceCabinet() {
    val spiceCabinet = listOf(SpiceContainer(Curry("Yellow Curry", "mild")),
        SpiceContainer(Curry("Red Curry", "medium")),
        SpiceContainer(Curry("Green Curry", "spicy")))

    for(element in spiceCabinet) println(element.label)
}





