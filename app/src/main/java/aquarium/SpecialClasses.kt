package aquarium

/**
 * To create a singleton,
 * use the object keyword when you declare a class, and that's it
 *
 * There can be only one Moby Dick, so we declare it as object,
 * instead of a class.
 */
object MobyDickWhale {

    val author = "Herman Melville"

    fun jump() {
        // ...
    }
}

/**
 * Enums are like the Moby Dick object.
 * Kotlin will make exactly one red,
 * exactly one green, and
 * exactly one blue.
 *
 * There is no way to create more than one color object.
 * There's not any way to define more colors, other than where the enum is declared.
 */
enum class Color(val rgb: Int) {
    RED(0xFF0000),
    GREEN(0x00FF00),
    BLUE(0x0000FF)
}

/**
 * Sealed class is special.
 * It can be subclassed, but only inside the file which it's declared.
 * If you try to subclass it in a different file, you'll get an error.
 *
 * Kotlin will be able to know all subclasses statically, at compile time :)
 * Sealed classed are a safe way to represent a fixed number of times.
 * They're great for returning success or an err. from a network API, for example.
 */
sealed class Seal

class SeaLion: Seal()
class Walrus: Seal()

fun matchSeal(seal: Seal): String {
    return when(seal) {
        is Walrus -> "walrus"
        is SeaLion -> "sea lion"
    }
}