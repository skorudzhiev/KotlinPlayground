package aquarium

fun labels() {

    // To label an expression we just put a label in front of it.
    loop@ for (i in 1..100) {
        for (j in 1..100) {
            if (i > 10) break@loop
        }
    }
}