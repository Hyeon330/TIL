package chap08.section2

fun main() {
    val arr = arrayOf(8,4,3,2,5,9,1)

    val sortedNums = arr.sortedArray()
    println("ASC: ${sortedNums.contentToString()}")

    val sortedNumsDesc = arr.sortedArrayDescending()
    println("DEC: ${sortedNumsDesc.contentToString()}")

    arr.sort(1,5)
    println("ORI: ${arr.contentToString()}")
    arr.sortDescending()
    println("ORI: ${arr.contentToString()}")

    val listSorted: List<Int> = arr.sorted()
    val listDesc: List<Int> = arr.sortedDescending()
    println("LST: ${listSorted}")
    println("LST: ${listDesc}")

    val items = arrayOf<String>("Dog", "Cat", "Lion", "Kangaroo", "Po")
    items.sortBy { item -> item.length }
    println(items.contentToString())
}