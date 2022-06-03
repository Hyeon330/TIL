package chap03.section5

fun main() {
    val source = "Kotlin"
    val target = "Hello World!"
    println(source.getLongString(target))
}

fun String.getLongString(target: String): String =
    if(this.length > target.length) this else target