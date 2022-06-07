package chap09.section4

fun main() {
    val list = listOf(1,2,3,4,5,6)
    val listPair = listOf(Pair("A", 300), Pair("B", 200), Pair("C",100))
    val map = mapOf(11 to "Java", 22 to "Kotlin", 33 to "C++")

    list.forEach { print("$it ") }
    println()
    list.forEachIndexed{i,v -> println("index[$i]: $v")}

    println()

    val returnedList = list.onEach { print(it) }
    println()
    val returnedMap = map.onEach { println("key: ${it.key}, value: ${it.value}") }
    println("returnedList = $returnedList")
    println("returnedMap = $returnedMap")

    println()

    println(list.count { it % 2 == 0})

    println()

    println(list.maxOf { it })
    println(list.minOf { it })

    println("maxBy: " + map.maxByOrNull { it.key })
    println("minBy: " + map.minByOrNull { it.key })

    println()

    println(list.fold(4) { total, next -> total + next })
    println(list.fold(1) { total, next -> total * next })

    println(list.foldRight(4) {total, next -> total + next})
    println(list.foldRight(1) {total, next -> total * next})

    println(list.reduce { total, next -> total + next })
    println(list.reduceRight { total, next -> total + next })

    println()

    println(listPair.sumOf { it.second })
}