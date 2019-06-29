package aquarium

import kotlin.reflect.full.declaredMemberFunctions
import kotlin.reflect.full.findAnnotation

@ImAPlant
class Plant {
    fun trim() {}
    fun fertilize() {}

    @get:OnGet
    val isGrowing: Boolean = true

    @set:OnSet
    var needsFood: Boolean = false
}

annotation class ImAPlant

@Target(AnnotationTarget.PROPERTY_GETTER)
annotation class OnGet

@Target(AnnotationTarget.PROPERTY_SETTER)
annotation class OnSet

fun reflections() {

    // Using reflection to get information about the class at runtime
    // That's the colon colon class operation
    val classObj = Plant::class

    // Printing all of the methods on the class
    for (method in classObj.declaredMemberFunctions) {
        println(method.name)
    }

    // find one annotation, or null
    val annotated = classObj.findAnnotation<ImAPlant>()

    annotated?.apply { println("Found a plant annotation") }
}