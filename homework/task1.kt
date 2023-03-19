import java.util.*

fun main() {
    println("Enter a year (e.g. 2021 or 45 BC):")
    val input = readLine()

    if (input != null) {
        val result = yearToCentury(input)
        println(result)
    } else {
        println("No input received")
    }
}

fun yearToCentury(input: String): String {
    val parts = input.split(" ")
    val year = parts[0].toInt()
    var era = if (parts.size > 1) parts[1] else ""
    if (era == "") {
        era = "AD"
    } 
    val century: Int
    val suffix: String
    century = (year - 1) / 100 + 1


    suffix = when (century % 10) {
        1 -> if (century != 11) "st" else "th"
        2 -> if (century != 12) "nd" else "th"
        3 -> if (century != 13) "rd" else "th"
        else -> "th"
    }

    return "${century}$suffix century $era"
}
