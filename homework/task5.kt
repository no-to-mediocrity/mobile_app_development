fun main() {
    val input = mutableListOf<Int>()

    // Prompt user to input 4 integers
    for (i in 1..4) {
        print("Enter integer $i: ")
        val num = readLine()?.toIntOrNull()

        if (num == null) {
            println("Invalid input, please enter an integer.")
            return
        } else {
            input.add(num)
        }
    }
    println(prod2sum(input))   
}

fun prod2sum(num: MutableList<Int>): List<Pair<Int, Int>> {
    val target = (num[0] * num[0] + num[1] * num[1]) * (num[2] * num[2] + num[3] * num[3])
    var combinations = arrayOf(Pair(0, 2), Pair(0, 3), Pair(1, 2), Pair(1, 3), Pair(0, 1), Pair(2, 3))
    var possible_answers = mutableListOf<Int>()
    var answers = mutableListOf<Pair<Int, Int>>()
    
    for (combo1 in combinations) {
        var possible1: Int?
        var possible2: Int?
        for (combo2 in combinations) {
            if (!(combo1.first == combo2.first || combo1.first == combo2.second || combo1.second == combo2.first || combo1.second == combo2.second)){
                possible1 = num[combo1.first] * num[combo1.second] + num[combo2.first] * num[combo2.second]
                possible2 = num[combo1.first] * num[combo1.second] - num[combo2.first] * num[combo2.second]
                if (possible1 > 0 && possible1 !in possible_answers) {
                    possible_answers.add(possible1)
                }
                if (possible2 > 0 && possible2 !in possible_answers) {
                    possible_answers.add(possible2)
                }
            }
        }
    }
   

    for (num1 in possible_answers) {
        for (num2 in possible_answers) {
            if (num1 * num1 + num2 * num2 == target && sortPair(Pair(num1, num2)) !in answers) {
                answers.add(sortPair(Pair(num1, num2)))
            }
        }
    }
    return answers.sortedBy { it.first }
}

fun sortPair(pair: Pair<Int, Int>): Pair<Int, Int> {
    val sortedValues = listOf(pair.first, pair.second).sorted()
    return Pair(sortedValues[0], sortedValues[1])
}
