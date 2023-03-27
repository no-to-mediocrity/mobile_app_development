fun main() {
    val k = readLine()?.toIntOrNull() ?: return
        var g = listOf(1, 1)
        var occurrences = 0
        for (j in 1..k) {
            g = extendList(g, k)
        }
        for (item in g) {
            if (item == k) {
                occurrences++
            }
        }
        if (k == 2) {
            println("$occurrences")
        } else {
            println("${occurrences * 2}")
        }
    
}

fun extendList(list: List<Int>, max: Int): List<Int> {
    val temp = mutableListOf<Int>()
    var prev = 0
    for ((index, value) in list.withIndex()) {
        if (index != 0) {
            val new = value + prev
            temp.add(prev)
            if ((new <= max) || (new + prev <= max || new + value <= max && (new != max))) {
                temp.add(new)
            }
        }
        if (value == 2) {
            temp.add(value)
            break
        }
        prev = value
    }
    return temp
}
