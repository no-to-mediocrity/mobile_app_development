import java.util.*

fun main() {
    println("Enter a number:")
    val input = readLine()

    if (input != null) {
        if (input.toInt() < 1) { // < 1 неслучайно, на ноль мы получим пустой массив, поэтому зачем считать ¯\_(ツ)_/¯
         println(0)   
        } else {
        val result = findNumbers(input.toInt())
        println(result)
        }
    } else {
        println("No input received")
    }
}

fun findNumbers(number: Int): Int {
    val answers = mutableListOf<Int>()
    for (i in 1 until number) {
        if ((i % 3 == 0 || i % 5 == 0) && !answers.contains(i)) {
            answers.add(i)
        }
    }
    return answers.sum()
}
