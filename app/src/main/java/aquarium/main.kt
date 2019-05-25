package aquarium

fun main() {
    buildAquarium()
    makeFish()
}

internal fun buildAquarium() {
    val myAquarium = Aquarium()

    println("Length: ${myAquarium.length} " +
            "Width: ${myAquarium.width} " +
            "Height: ${myAquarium.height}")

    myAquarium.height = 80

    println("Height: ${myAquarium.height} cm")

    println("Volume: ${myAquarium.volume} liters")

    val smallAquarium = Aquarium(length = 20, width = 15, height = 30)
    println("Small Aquarium: ${smallAquarium.volume} liters")

    val myAquarium2 = Aquarium(numberOfFish = 9)

    println("Small Aquarium 2: ${myAquarium2.volume} liters with " +
            "length: ${myAquarium2.length} " +
            "width: ${myAquarium2.width} " +
            "height: ${myAquarium2.height} ")
}

fun makeFish() {
    val shark = Shark()
    val pleco = Plescostomus()

    println("Shark: ${shark.color} \n Plescostomus: ${pleco.color}")

    shark.eat()
    pleco.eat()
}

fun feedFish(fish: FishAction) {
    // make some food then
    fish.eat()
}
