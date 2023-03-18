import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    println("Enter a time value in the format of 'HH:mm':")
    val input = scanner.nextLine()
    val (hours, minutes) = parseInput(input)
    var mirrorTime = calculateMirrorTime(hours, minutes)
    println("Mirror time: ${formatTime(mirrorTime)}")
}

fun parseInput(input: String): Pair<Int, Int> {
    require(input.length == 5 && input[2] == ':') { "Invalid input: $input" }
    val hours = input.substring(0, 2).toIntOrNull()
    require(hours != null && hours in 0..12) { "Invalid hours: $hours" }
    val minutes = input.substring(3, 5).toIntOrNull()
    require(minutes != null && minutes in 0..59) { "Invalid minutes: $minutes" }
    return Pair(hours, minutes)
}

fun calculateMirrorTime(hours: Int, minutes: Int): Pair<Int, Int> {
    var mirrorHours: Int?
    val mirrorMinutes = 60 - minutes
    if ((hours == 0) || (hours == 12)) {
        mirrorHours = hours
    } else {
        mirrorHours =  12 - hours
    }
    return Pair(mirrorHours, mirrorMinutes)
}

fun formatTime(time: Pair<Int, Int>): String {
    return String.format("%02d:%02d", time.first, time.second)
}
