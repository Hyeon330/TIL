package chap04.section1

fun main() {
    cases("fdsa")
}

fun cases(obj: Any?){
    when (obj) {
        is String -> println("String")
        is Int -> println("Int")
        is Double -> println("Double")
        is Char -> println("Char")
        else -> println("other")
    }
}