package chap02.section3

fun main() {
    var str1: String? = "Hello"
    str1 = null
    println("str1: ${str1?.length}")
}