package org.example.kotlin.`in`.action.chapter9

//fun <T> isA(value: Any) = value is T

inline fun <reified T> isA(value: Any) = value is T

fun main() {
    println(isA<String>("abc"))
    println(isA<String>(123))

    val items = listOf("one", 2, "three")
    println(items.filterIsInstance<String>())
}
