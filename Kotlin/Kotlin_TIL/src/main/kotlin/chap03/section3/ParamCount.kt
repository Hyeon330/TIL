package chap03.section3

fun main() {
    // 매개변수가 1개인 경우 화살표 표기를 생략하고 $it으로 대체 가능
    oneParam { "Hello World! $it" }

    // 매개변수가 2개 이상인 경우 매개변수 이름 생략 불가
    moreParam{ a, b -> "Hello Kotlin! $a $b"}

    // 특정 람다식의 매개변수를 사용하고 싶지 않을 때는 이름 대신 언더스코어(_)로 대체
    moreParam{ _, b -> "Hellow Kotlin $b"}

    // 인자와 함께 람다식을 사용하는 경우 함수의 마지막 인자가 람다식인 경우소괄호 바깥으로 분리 가능
    withArgs("Arg1", "Arg2",) {a, b ->
        "Hello World! $a $b"
    }
}

fun oneParam(out: (String) -> String) {
    println(out("OneParam"))
}

fun moreParam(out: (String, String) -> String) = println(out("OneParam", "TwoParam"))

fun withArgs(a: String, b: String, out: (String, String) -> String) {
    println(out(a, b))
}