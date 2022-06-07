package chap09.section5

fun main() {
    val nums: Sequence<Int> = generateSequence(1) { it + 1 }

    println(nums.take(10).toList())
}