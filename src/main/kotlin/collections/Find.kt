package org.example.collections

fun find() {
    val words = listOf("컬렉션에", "있는", "어떤", "아이템", "골라서", "찾기", "아이들")           // 1
    println(words)
    val first = words.find { it.startsWith("아이") }                                // 2
    println(first)
    val last = words.findLast { it.startsWith("아이") }                             // 3
    println(last)
    val nothing = words.find { it.contains("없는") }                                // 4
    println(nothing)
}

fun main() {
    find()
}
