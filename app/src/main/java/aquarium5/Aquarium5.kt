package aquarium5

data class Fish(var name: String)

fun main() {
    fishExamples()
}

fun fishExamples() {
    val fish = Fish("splashy")

    // without inline an object is created with every call to myWith
    myWith(fish.name, object : Function1<String, Unit> {
        override fun invoke(name: String) {
            name.capitalize()
        }
    })

    // with inline no object is created, and lambda body is inlined here
    fish.name.capitalize()

    println(fish.run { name })
    println(fish.apply {})

    val fish2 = Fish(name = "Splashy").apply { name = "Sharky" }
    println(fish2)

    println(fish.let { it.name.capitalize() }
        .let { "$it fish" }
        .let { it.length }
        .let { it + 31 })
}

inline fun myWith(name: String, block: String.() -> Unit) {
    name.block()
}
