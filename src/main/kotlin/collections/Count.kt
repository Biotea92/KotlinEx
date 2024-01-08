package org.example.collections


fun count() {
    val numbers = listOf(1, -2, 3, -4, 5, -6)            // 1
    println("numbers = ${numbers}")
    val totalCount = numbers.count()                     // 2
    println("totalCount = ${totalCount}")
    val evenCount = numbers.count { it % 2 == 0 }        // 3
    println("evenCount = ${evenCount}")
}

fun main() {
    count()
}
