package chap09.section4

fun main() {
    val list = listOf(1,2,3,4,5,6)
    val listMixed = listOf(1, "Hello", 3, "World", 5, 'A')
    val listWithNull = listOf(1, null, 3, null, 5, 6)
    val listRepeated = listOf(2,2,3,4,5,5,6)
    val map = mapOf(11 to "Java", 22 to "Kotlin", 33 to "C++")

    println(list.filter { it % 2 == 0 })    // (널 포함)짝수
    println(list.filterNot { it % 2 == 0 }) // (널 포함)홀수
    println(listWithNull.filterNotNull())   // 널 제외

    println()

    println("filterIndexed: " + list.filterIndexed { i, v -> i != 1 && v % 2 == 0 })

    val mutList = list.filterIndexedTo(mutableListOf()) { i, v -> i != 1 && v % 2 ==0 }
    println("filterIndexedTo: $mutList")

    println()

    println("filterKeys: " + map.filterKeys { it != 11 })
    println("filterValues: " + map.filterValues { it == "Java" })

    println()

    println("filterIsInstance: " + listMixed.filterIsInstance<String>())
    println("filterIsInstance: " + listMixed.filterIsInstance<Int>())
    println("filterIsInstance: " + listMixed.filterIsInstance<Any>())

    println()

    println("slice: " + list.slice(listOf(0, 1, 2)))

    println()

    println("component1(): " + list.component3())

}