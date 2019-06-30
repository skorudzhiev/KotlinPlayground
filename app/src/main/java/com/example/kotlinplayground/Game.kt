package com.example.kotlinplayground

fun main() {
    val game = Game()
    println(game.path)
    game.north()
    game.south()
    game.east()
    game.west()
    game.end()
    println(game.path)

    while (true) {
        print("Enter a direction: n/s/e/w: ")
        game.makeMove(readLine())
    }
}

enum class Direction {
    NORTH, EAST, WEST, SOUTH, START, END
}

/**
 * Challenge:
Create a simple “map” for your game, and when the user moves, show a description of their location. Consider the following:
• Use a Location class that takes a default width and height to track location. 4x4 is pretty manageable.
• You can create a matrix like this:
val map = Array(width) { arrayOfNulls<String>(height) }

• Use an init block to initialize your map with descriptions for each location.
• When you move() also updateLocation(). There is some math involved to prevent null-pointer exceptions and keep the user from walking off the map. rem() and absoluteValue come handy.
When you are done, zip up the code and send it to a friend to try your first Kotlin game.
 */
class Game {
    var path = mutableListOf(Direction.START)
    val north = { path.add(Direction.NORTH) }
    val south = { path.add(Direction.SOUTH) }
    val east = { path.add(Direction.EAST) }
    val west = { path.add(Direction.WEST) }
    val end = { path.add(Direction.END); println("Game Over: $path"); path.clear(); false }

    private fun move(where: () -> Boolean ) {
        where.invoke()
    }

    fun makeMove(command:String?) {
        when {
            command.equals("n") -> move(north)
            command.equals("s") -> move(south)
            command.equals("e") -> move(east)
            command.equals("w") -> move(west)
            else -> move(end)
        }
    }
}

