package org.example.collections

fun main() {
    val map = mapOf("키" to 42)
    println("map = ${map}")

    val value1 = map["키"]                                     // 1
    println("value1 = ${value1}")
    val value2 = map["키2"]                                    // 2
    println("value2 = ${value2}")

    val value3: Int = map.getValue("키")                       // 1
    println("value3 = ${value3}")

    val mapWithDefault = map.withDefault { k -> k.length }
    println("mapWithDefault = ${mapWithDefault}")
    val value4 = mapWithDefault.getValue("키2")                // 3
    println("value4 = ${value4}")

    try {
        map.getValue("없는 키")                                 // 4
    } catch (e: NoSuchElementException) {
        println("메시지: $e")
    }
}
