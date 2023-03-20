fun main() {
    println("Enter a string:")
    val input = readLine()
   if (input != null) {
            val result = camelCase(input)
            println(result)
        } else {
            println("No input received")
        }
    }

fun camelCase(input: String): String {
    val delimiters = arrayOf('-', '_')
    var nextword = false
    if (input[0] == input[0].uppercaseChar()){
        nextword = true
    }
    val answer = mutableListOf<Char>()

    for (char in input) {
        if (char in delimiters) {
            nextword = true
            continue
        }
        if (nextword) {
            answer.add(char.uppercaseChar())
            nextword = false
        } else {
            answer.add(char.lowercaseChar())
        }
    }
    return answer.joinToString("")
}
