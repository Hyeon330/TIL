package chap02.section3

fun main() {
    var str1: String? = "hello"
    str1 = null
    println("str1: $str1 length: ${str1?.length ?: -1}")

    val a: Int = 128
    val b: Int? = 128
    val c: Int? = 129
    println(a == b)
    println(a === b)
    println(b === c)
}