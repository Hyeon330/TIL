package chap03.section3

fun main() {
    towLambda({a, b -> "First $a $b"}){"Second $it"}
}

fun towLambda(first: (String, String) -> String, second: (String) -> String) {
    println(first("f_OneParam", "f_TwoParam"))
    println(second("s_OneParam"))
}