package chap04.section1

fun main() {
    print("Enter the score: ")
    var score = readLine()!!.toDouble()

    var grade = when {
        score >= 90.0 -> 'A'
        score in 80.0..89.9 -> 'B'
        score in 70.0..79.9 -> 'C'
        else -> 'F'
    }

    println("Score: $score, Grade: $grade")
}