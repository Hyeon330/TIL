package chap08.section1

fun main() {
    val result = getType<Int>(13.123)
    println("result = $result")

    println(String::class)
    println(""::class)
    println(0::class == Int::class)
}

inline fun <reified T> getType(value: Number): T {
    println(T::class) // 실행 시간에 삭제되지 않고 사용 가능
    println(T::class.java)

    return when (T::class) { // 받아들인 제네릭 자료형에 따라 반환
        Float::class -> value.toFloat() as T
        Int::class -> value.toInt() as T
        else -> throw IllegalStateException("${T::class} is not supported!")
    }
}