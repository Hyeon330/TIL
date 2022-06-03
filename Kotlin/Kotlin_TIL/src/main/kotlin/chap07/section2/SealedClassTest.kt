package chap07.section2

//sealed class Result {
//    open class Success(val message: String): Result()
//    class Error(val code: Int, val message: String): Result()
//}

sealed class Result

open class Success(val message: String): Result()
class Error(val code: Int, val message: String): Result()

class Status: Result()
class Inside: Success("Status")

fun main() {
    val result = Success("Good!!")
    val msg = eval(result)

    println(msg)
}

fun eval(result: Result): String = when(result) {
    is Status -> "in progress"
    is Success -> result.message
    is Error -> result.message
}