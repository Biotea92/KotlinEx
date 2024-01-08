package org.example.common.variable

fun main() {
    var a: String = "처음값"    // 1
    println(a)
    val b: Int = 1             // 2
    println(b)
    val c = 3                  // 3
    println(c)

//    초기화 하지 않고 변수 선언시 Variable 'e' must be initialized 에러
//    var e: Int
//    println(e)

    val d: Int  // 1

    if (someCondition()) {
        d = 1   // 2
    } else {
        d = 2   // 2
    }

    println(d) // 3
}

fun someCondition(): Boolean {
    return true
}
