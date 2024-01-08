package org.example.blockfunction

fun writeCreationLog(p: Person) {
    println("${p.name} 인스턴스를 만들었습니다.")
}

fun main() {
    val jake = Person("Jake", 30, "안드로이드 개발자")      // 1
        .also {                                          // 2
            writeCreationLog(it)                         // 3
        }
}
