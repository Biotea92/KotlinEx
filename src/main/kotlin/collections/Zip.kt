package org.example.collections

fun main() {
    val A = listOf("a", "b", "c")                  // 1
    println("A = ${A}")
    val B = listOf(1, 2, 3, 4)                     // 1
    println("B = ${B}")

    val resultPairs = A zip B                      // 2
    println("resultPairs = ${resultPairs}")
    val resultReduce = A.zip(B) { a, b -> "$a$b" } // 3
    println("resultReduce = ${resultReduce}")
}
