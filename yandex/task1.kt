import java.util.*

fun main() {
//    println("Please enter two integers separated by a space:")
    val input = readLine()
    val regex = Regex("\\d+\\s\\d+")
   if (input == null || !regex.matches(input)) {
    //    println("Invalid input. Please provide two integers separated by a space.")
        return
    }
    val (hours, minutes) = input.split(" ").map { it.toInt() }
    if (hours !in 0..11 || minutes !in 0..59) {
  //      println("Invalid input. Please provide hours between 0 and 11, and minutes between 0 and 59.")
        return
    }
     var mirrorTime = calculateMirrorTime(hours, minutes)
    println("${formatTime(mirrorTime)}")
}


fun calculateMirrorTime(hours: Int, minutes: Int): Pair<Int, Int> {
    var mirrorHours: Int?
    var mirrorMinutes: Int?
    if (hours == 0) {
        mirrorHours = hours
    } else {
        mirrorHours =  12 - hours
    }
    if (minutes == 0) {
        mirrorMinutes = minutes
    } else {
        mirrorMinutes =  60 - minutes
    }
    return Pair(mirrorHours, mirrorMinutes)
}

fun formatTime(time: Pair<Int, Int>): String {
    return String.format("%d %d", time.first, time.second)
}
