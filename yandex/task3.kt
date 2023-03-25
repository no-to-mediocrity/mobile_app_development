data class Shape(val type: Int, val coordinates: List<Int>)

fun main() {
    val n = readLine()!!.toInt()
    val shapes = mutableListOf<Shape>()

    for (i in 1..n) {
        val input = readLine()!!.split(" ").map { it.toInt() }
        val type = input[0].toInt()
        val coordinates = input.subList(1, input.size).map { it.toInt() }
        shapes.add(Shape(type, coordinates))
    }

    val centers = mutableListOf<Pair<Double, Double>>()
    for (shape in shapes) {
        if (shape.type == 0) { // Circle
            val centerX = shape.coordinates[0].toDouble()
            val centerY = shape.coordinates[1].toDouble()
            centers.add(Pair(centerX, centerY))
        } else if (shape.type == 1) { // Rectangle
            val x1 = shape.coordinates[0]
            val y1 = shape.coordinates[1]
            val x2 = shape.coordinates[2]
            val y2 = shape.coordinates[3]
            val x3 = shape.coordinates[4]
            val y3 = shape.coordinates[5]
            val x4 = shape.coordinates[6]
            val y4 = shape.coordinates[7]
            val centerX = (x1 + x2 + x3 + x4) / 4.0
            val centerY = (y1 + y2 + y3 + y4) / 4.0
            centers.add(Pair(centerX, centerY))
        }
    }

    if (centers.size < 3) {
        println("Yes")
        return
    }
    println(checkIfOnSameLine(centers))
 
}

fun checkIfOnSameLine(centers: List<Pair<Double, Double>>): String {
    var prevSlope: Double? = null
    for (i in 0 until centers.size - 1) {
        val x1 = centers[i].first
        val y1 = centers[i].second
        val x2 = centers[i + 1].first
        val y2 = centers[i + 1].second
        val determinant = x1 * y2 - y1 * x2
        val slope = (y2 - y1) / (x2 - x1)
        if (determinant == 0.0) {
            if (prevSlope != null && slope != prevSlope) {
                return "No"
            }
            prevSlope = slope
        } else {
            return "No"
        }
    }
    return "Yes"
}
