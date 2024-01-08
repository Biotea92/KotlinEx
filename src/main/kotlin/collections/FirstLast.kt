package org.example.collections

fun firstLast() {
    val numbers = listOf(1, -2, 3, -4, 5, -6)            // 1
    println(numbers)
    val first = numbers.first()                          // 2
    println(first)
    val last = numbers.last()                            // 3
    println(last)

    val firstEven = numbers.first { it % 2 == 0 }        // 4
    println(firstEven)
    val lastOdd = numbers.last { it % 2 != 0 }           // 5
    println(lastOdd)
}

fun firstOrNullLastOrNull() {
    val words = listOf("foo", "bar", "baz", "faz")         // 1
    println("words = ${words}")
    val empty = emptyList<String>()                        // 2
    println("empty = ${empty}")

    val first = empty.firstOrNull()                        // 3
    println("first = ${first}")
    val last = empty.lastOrNull()                          // 4
    println("last = ${last}")

    val firstF = words.firstOrNull { it.startsWith('f') }  // 5
    println("firstF = ${firstF}")
    val firstZ = words.firstOrNull { it.startsWith('z') }  // 6
    println("firstZ = ${firstZ}")
    val lastF = words.lastOrNull { it.endsWith('f') }      // 7
    println("lastF = ${lastF}")
    val lastZ = words.lastOrNull { it.endsWith('z') }      // 8
    println("lastZ = ${lastZ}")
}

fun main() {
    firstLast()
    firstOrNullLastOrNull()
}
