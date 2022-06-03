package chap08.section1.limit

open class Animal(val size: Int) {
    fun feed() = println("Feeding...")
}

class Cat(val jump: Int): Animal(50)
class Spider(val poison: Boolean): Animal(1)

class Box<out T: Animal>(val element: T) {
    fun getAnimal(): T = element    // out 자료형은 반환 자료형에만 사용할 수 있음
//    fun set(new: T) { // 오류! T는 in위치에 사용할 수 없음
//        element = new
//    }
}

fun main() {
    val c1: Cat = Cat(10)
    val s1: Spider = Spider(true)

    var a1: Animal = c1
    a1 = s1
    println("a1.size = ${a1.size}")

    val c2: Box<Animal> = Box<Cat>(Cat(10))
    println("c2.element.size = ${c2.element.size}")

    a1.feed()
    c1.feed()
    c2.element.feed()
}