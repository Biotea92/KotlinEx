package org.example.kotlin.`in`.action.chapter8


fun main() {

//    val sum = { x: Int, y: Int -> x + y }
//    val action = { println(42) }

    val sum: (Int, Int) -> Int = { x, y -> x + y }
    val action: () -> Unit = { println(42) }
    val canReturnNull: (Int, Int) -> Int? = { _, _ -> null }
    val funOrNull: ((Int, Int) -> Int)? = null

    println(sum(1, 2))
    action()
    println(canReturnNull(1, 2))

    fun twoAndThree(operation: (Int, Int) -> Int) {
        val result = operation(2, 3)
        println("The result is $result")
    }

    twoAndThree { a, b -> a + b }
    twoAndThree { a, b -> a * b }

    fun String.filter(predicate: (Char) -> Boolean): String {
        val sb = StringBuilder()
        for (index in 0 until length) {
            val element = get(index)
            if (predicate(element)) sb.append(element)
        }
        return sb.toString()
    }

    println("ab1c".filter { it in 'a'..'z' })
}
