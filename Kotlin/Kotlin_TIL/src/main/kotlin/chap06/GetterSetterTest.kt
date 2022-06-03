package chap06

class User1(val id: Int, var name: String, var age: Int)

fun main() {
    val user = User1(1, "Sean", 30)

    val name = user.name

    user.age = 41

    println("name: $name, ${user.age}")

}