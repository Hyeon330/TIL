package chap04.section2

fun main() {
    var odd = 0
    var even = 0
    for (num in 1..99) {
        when (num%2) {
            0 -> even += num
            1 -> odd += num
        }
    }

    println("Odd total: $odd")
    println("Even total: $even")
    println("Total: ${odd+even}")

}