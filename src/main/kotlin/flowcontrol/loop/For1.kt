package org.example.flowcontrol.loop

fun main() {
    val cakes = listOf("당근", "치즈", "초콜릿")

    for (cake in cakes) {                               // 1
        println("맛있는 ${cake}케이크!")
    }
}
