package org.example.productivitybooster

fun findMinMax(list: List<Int>): Pair<Int, Int> {
    // do the math
    return Pair(50, 100)
}
fun main() {
    val (x, y, z) = arrayOf(5, 10, 15)                              // 1
    println("x = ${x} y = ${y} z = ${z}")

    val map = mapOf("손석구" to 40, "장도연" to 38)
    for ((name, age) in map) {                                      // 2
        println("${name}님은 올해 ${age}세입니다.")
    }

    val (min, max) = findMinMax(listOf(100, 90, 50, 98, 76, 83))    // 3
    println("min = ${min} max = ${max}")
}
