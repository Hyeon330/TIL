package chap02.section3

fun main() {
    checkArg("5")
    checkArg(5)
}

fun checkArg(x: Any) {
    if(x is String) println("$x is String")
    if(x is Int) println("$x is Int")
}