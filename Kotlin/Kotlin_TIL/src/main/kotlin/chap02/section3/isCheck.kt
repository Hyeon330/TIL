package chap02.section3

fun main() {
    val num = 256

    if(num is Int) {
        println(num)
    } else {
        println("Not a Int")
    }
    println()

    val x: Any
    x = "hello"
    println(x.javaClass)
    if(x is String) {
        println(x.length)
        println(x.javaClass)
    }
    println(x.javaClass)
}