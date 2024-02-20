package org.example.kotlin.`in`.action.chapter7

data class Point(val x: Int, val y: Int) {
    override fun equals(obj: Any?): Boolean {
        if (obj === this) return true
        if (obj !is Point) return false
        return obj.x == x && obj.y == y
    }

    override fun hashCode(): Int {
        var result = x
        result = 31 * result + y
        return result
    }
}

operator fun Point.plus(other: Point): Point {
    return Point(x + other.x, y + other.y)
}

operator fun Point.minus(other: Point): Point {
    return Point(x - other.x, y - other.y)
}

operator fun Point.times(scale: Double): Point {
    return Point((x * scale).toInt(), (y * scale).toInt())
}

operator fun Double.times(p: Point): Point {
    return Point((p.x * this).toInt(), (p.y * this).toInt())
}

operator fun Point.unaryMinus(): Point {
    return Point(-x, -y)
}

operator fun Point.get(index: Int) : Int {
    return when(index) {
        0 -> x
        1 -> y
        else -> throw IndexOutOfBoundsException("Invalid coordinate $index")
    }
}

operator fun Char.times(count: Int): String {
    return toString().repeat(count)
}

fun String.cutFirst(): String {
    return substring(1)
}

fun main() {
    val p1 = Point(10, 20)
    val p2 = Point(30, 40)
    println(p1 + p2)
    println(p1 - p2)
    println(p1 * 1.5)
    println(2.0 * p1)

    println('a' * 3)

    var point = Point(1, 2)
    point += Point(3, 4)
    println(point)

    val numbers = ArrayList<Int>()
    numbers += 42
    println(numbers[0])


    val list = arrayListOf(1, 2)
    list += 3
    val newList = list + listOf(4, 5)
    println(list)
    println(newList)

    val str = "Kotlin"
    println(str.cutFirst())

    println(-point)

    println(Point(10, 20) == Point(10, 20))
    println(Point(10, 20) != Point(5, 5))
    println(null == Point(1, 2))

    println(point[0])
    println(point[1])
}
