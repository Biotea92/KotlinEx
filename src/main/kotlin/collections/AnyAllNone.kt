package org.example.collections

fun any() {
    val numbers = listOf(1, -2, 3, -4, 5, -6)            // 1
    println(numbers)
    val anyNegative = numbers.any { it < 0 }             // 2
    println(anyNegative)
    val anyGT6 = numbers.any { it > 6 }                  // 3
    println(anyGT6)
}

fun all() {
    val numbers = listOf(1, -2, 3, -4, 5, -6)            // 1
    println(numbers)
    val allEven = numbers.all { it % 2 == 0 }            // 2
    println(allEven)
    val allLess6 = numbers.all { it < 6 }                // 3
    println(allLess6)
}

fun none() {
    val numbers = listOf(1, -2, 3, -4, 5, -6)            // 1
    println(numbers)
    val allEven = numbers.none { it % 2 == 1 }           // 2
    println(allEven)
    val allLess6 = numbers.none { it > 6 }               // 3
    println(allLess6)
}

fun main() {
    any()
    all()
    none()
}
