package chap08.section3

import java.io.*

private fun calculatePrice(orig: Float, x: Float): Unit {
    val result = orig * x
    println("최종 가격은 \$$result 입니다.")
}

fun main() {
    val booksName = arrayOf("java", "c", "c++", "kotlin", "c#", "html")
    val price = 200.0f
    val studentDiscount = .75f
    val teacherDiscount = .85f

    val bf = BufferedReader(InputStreamReader(System.`in`))
    println("** 오리의 서점에 오신 걸 환영합니다. **")
    do {
        println(booksName.contentToString())
        println("어떤 책을 원하시나요?")
        print(": ")

        val book = bf.readLine()

        if(booksName.contains(book.toLowerCase())) {
            println("선택하신 책은 $book 입니다. 가격은 \$${price.toInt()}")
            println("학생과 선생님인 경우에 할인을 적용하고 있습니다." +
                    "\n당신의 직업은 무엇인가요?( 1.student, 2.teacher, 3.etc )")
            print(": ")
            val occupation = bf.readLine().toIntOrNull()

            when(occupation) {
                1 -> calculatePrice(price, studentDiscount)
                2 -> calculatePrice(price, teacherDiscount)
                else -> println("할인을 적용할 수 없습니다." +
                                "\n최종 가격은 \$${price.toInt()} 입니다.")
            }
        }else if(book == "exit" || book == "q") {
            break
        } else {
            println("죄송합니다. $book 의 재고가 없습니다.")
        }
    } while(true)
}
