package chap09.section4

fun main() {
    val list1 = listOf(1,2,3,4,5,6)
    val list2 = listOf(2,2,3,4,5,5,6,7)

    println(list1.union(list2))
    println(list2.union(list1))

    println(list1.plus(list2))

    println()

    val part = list1.partition { it % 2 == 0 }
    println(part)
    println(part.first)
    println(part.second)

    println()

    // zip: 동일한 인덱스 끼리 Pair을 만들어 반환
    val zip = list1.zip(listOf(7,8))
    println(zip)
}