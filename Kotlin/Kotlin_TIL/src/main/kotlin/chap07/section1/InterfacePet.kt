package chap07.section1

interface Pet {
    var category: String
    val msgTags: String
        get() = "I'm your lovely pet!"
    fun feeding()
    fun patting() {
        println("Keep patting")
    }
}

class Cat(name: String, override var category: String) : Pet, Animal(name) {
    override fun feeding() {
        println("Feed the cat a tuna can!")
    }
}

fun main() {
    val obj = Cat("hh", "small")
    println("Pat Category: ${obj.category}")
    obj.feeding()
    obj.patting()

    println("Pet Message Tags: ${obj.msgTags}")
}