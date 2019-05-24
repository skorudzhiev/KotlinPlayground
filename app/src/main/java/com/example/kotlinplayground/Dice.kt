package com.example.kotlinplayground

import java.util.*

fun main() {
    gamePlay(rollDice2(4))
    gamePlay(rollDice1(3))
    gamePlay(rollDice(5))
}

    val rollDice = { sides: Int ->
        Random().nextInt(sides) + 1
    }
    val rollDice1 = { sides: Int ->
        if (sides == 0) 0
        else Random().nextInt(sides) + 1
    }
    val rollDice2: (Int) -> Int = { sides ->
        if (sides == 0) 0
        else Random().nextInt(sides) + 1
    }


fun gamePlay(diceRoll: Int){
    // do something with the dice roll
    println(diceRoll)
}