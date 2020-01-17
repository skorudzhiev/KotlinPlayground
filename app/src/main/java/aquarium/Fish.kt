package aquarium

class Fish(val friendly: Boolean = true, volumeNeeded: Int) {

    val size: Int

    init {
        println("first init block")
    }

    /**
     * In Kotlin you don't need a secondary constructor.
     * But if you do create a secondary constructor it must contain a call to the primary constructor
     * by using : this() - you must also have to pass any required arguments.
     */
    constructor(): this(true, 9) {
        println("running secondary constructor")
    }

    // init works just like a constructor
    init {
        if (friendly) {
            size = volumeNeeded
        } else {
            size = volumeNeeded * 2
        }
    }

    /**
     * You can have more than one init block and they always run before any secondary constructors.
     * And they can be almost anywhere in your class.
     * They're executed in the order from the top of the class to the bottom.
     */
    init {
        println("constructed fish of size $volumeNeeded final size ${this.size}")
    }

    init {
        println("last init block")
    }

    /**
     * Good Kotlin classes only define one constructor with default parameters for optional values.
     * If you would make a secondary constructor, consider making a secondary method instead.
     */
    fun makeDefaultFish() = Fish(true, 50)
    // This keeps your classes simple while providing a clean API

    // To write good Kotlin code, just use one primary constructors and init blocks
}

fun fishExample() {
    val fish = Fish(true, 20)
    println("Is the fish friendly? ${fish.friendly}. It needs volume ${fish.size}")
}