package decorations

fun main() {
    makeDecorations()
}

fun makeDecorations() {
    val d1 = Decorations("granite")
    println(d1)

    val d2 = Decorations("slate")
    println(d2)

    val d3 = Decorations("slate")
    println(d3)

    // Comparing data objects
    println(d1.equals(d2))
    println(d3.equals(d2))

    // Copy data objects
    val d4: Decorations = d3.copy()
    println(d3)
    println(d4)

    val d5 = Decorations2("crystal", "wood", "diver")
    println(d5)

    /**
     * Representation of using decomposition by
     * making three variables, one for each property and assign the object to it
     *
     * Kotlin puts the property value in each variable and then we can use it.
     * You need to put (parentheses) around the variables for decomposition.
     * The number of variables must match the number of properties
     * or you get a compiler error and
     * the variables are assigned in the order in which they are declared in class.
     *
     */
    val (rock, wood, diver) = d5
    println(rock)
    println(wood)
    println(diver)
}

/**
 * With the data class printing the object,
 * also prints the values of properties, instead of just an address of the object,
 * that is the object pointer
 */
data class Decorations(val rocks: String)

data class Decorations2(val rocks: String, val wood: String, val diver: String)

