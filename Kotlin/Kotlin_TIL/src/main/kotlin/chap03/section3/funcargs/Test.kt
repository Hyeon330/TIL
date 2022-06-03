package chap03.section3.funcargs

fun main() {
    println(highFunc1({x:Int, y:Int -> x + y},10,20 ))
    println(highFunc1({x:Int, y:Int -> x - y},10,20 ))
    println(highFunc1({x:Int, y:Int -> x * y},10,20 ))
    println(highFunc1(fun(x:Int, y:Int) = x / y,20,10 ))

//    println(highFunc2(fun(x: Int, y: Int) {
//        return "$x 와 $y"
//    }, 10, 20))   // 오류! 리턴 값을 정해주지 않아서 자동 Unit자료형 지정
    println(highFunc2(fun(x: Int, y: Int): String {
        return "$x 와 $y"
    }, 10, 20))
    println(highFunc2(fun(x: Int, y: Int) = "$x 와 $y", 10, 20))
}

fun highFunc1(sum: (Int, Int) -> Any, a: Int, b: Int) = sum(a,b)

val highFunc2 = {c: (Int, Int) -> Any, a: Int, b: Int -> c(a,b)}
