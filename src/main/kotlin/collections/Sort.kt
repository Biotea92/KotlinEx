package org.example.collections

import kotlin.math.abs

fun main() {
    val shuffled = listOf(5, 4, 2, 1, 3, -10)                   // 1
    println("shuffled = ${shuffled}")
    val natural = shuffled.sorted()                             // 2
    println("natural = ${natural}")
    val inverted = shuffled.sortedBy { -it }                    // 3
    println("inverted = ${inverted}")
    val descending = shuffled.sortedDescending()                // 4
    println("descending = ${descending}")
    val descendingBy = shuffled.sortedByDescending { abs(it)  } // 5
    println("descendingBy = ${descendingBy}")
}
