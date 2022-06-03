package chap06

class User4(_id: Int, _name: String, _age: Int) {
    val id: Int = _id
    private var tempName: String? = null
    var name: String = _name
        get() {
            if(tempName == null) tempName = "NONAME"
            return tempName ?: throw java.lang.AssertionError("Asserted by others")
        }
    var age: Int = _age
}

fun main() {
    val user = User4(1, "kildong", 35)
    user.name = ""
    println("user.name = ${user.name}")
}