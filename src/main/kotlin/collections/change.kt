package org.example.collections

fun map() {
    val numbers = listOf(1, -2, 3, -4, 5, -6)     // 1
    println("numbers = ${numbers}")

    val doubled = numbers.map { x -> x * 2 }      // 2
    println("doubled = ${doubled}")

    val tripled = numbers.map { it * 3 }          // 3
    println("tripled = ${tripled}")
}

fun main() {
    map()
}
