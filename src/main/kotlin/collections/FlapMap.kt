package org.example.collections

fun main() {
    val fruitsBag = listOf("사과", "오렌지", "바나나")             // 1
    val clothesBag = listOf("티셔츠", "양말", "청바지")            // 2
    val cart = listOf(fruitsBag, clothesBag)                    // 3
    val mapBag = cart.map { it }                                // 4
    val flatMapBag = cart.flatMap { it }                        // 5

    println("fruitsBag = ${fruitsBag}")
    println("clothesBag = ${clothesBag}")
    println("cart = ${cart}")
    println("mapBag = ${mapBag}")
    println("flatMapBag = ${flatMapBag}")
}
