package chap04.section1

fun main() {
    print("Enter the score: ")
    val score = readLine()!!.toDouble()
    var grade: Char = 'F'

    grade = if(score >= 90.0) {
        'A'
    }else if(score >= 80.0 && score <= 89.9){
        'B'
    }else if(score >= 70.0 && score <= 79.9) {
        'C'
    }else {
        grade
    }

    println("Score: $score, Grade: $grade")

    var g = if(score >= 90) {
        'A'
    }else if(score in 80.0..89.9) {
        'B'
    }else if(score in 70.0..79.9) {
        'C'
    }else {
        'F'
    }
    println(g)
}