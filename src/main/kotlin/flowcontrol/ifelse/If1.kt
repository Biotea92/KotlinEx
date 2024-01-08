package org.example.flowcontrol.ifelse

fun main() {
    fun max(a: Int, b: Int) = if (a > b) a else b         // 1

    // 코틀린은 삼항 연산자가 없다. if-else를 사용하면 된다.
    println(max(99, -42))
}
