package chap06.section1

open class First {
    open val x: Int = 0
    get() {
        println("First x")
        return field
    }

    val y: Int = 0
}

class Second: First() {
    override val x: Int = 0
    val z: Int = 0
}

fun main() {

}