package org.example.collections

fun main() {
    val numbers = listOf(1, -2, 3, -4, 5, -6)                 // 1
    println("numbers = ${numbers}")

    val evenOdd = numbers.partition { it % 2 == 0 }           // 2
    println("evenOdd = ${evenOdd}")
    val (positives, negatives) = numbers.partition { it > 0 } // 3
    println("positives = ${positives}")
    println("negatives = ${negatives}")
}
