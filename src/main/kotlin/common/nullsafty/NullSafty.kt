package org.example.common.nullsafty

fun main() {
    var neverNull: String = "이 변수는 null이 될 수 없습니다"    // 1

//    null 불가
//    neverNull = null                                         // 2

    var nullable: String? = "이 변수는 null이 될 수 있습니다"    // 3

    nullable = null                                          // 4

    var inferredNonNull = "컴파일러 타입추론은 null-불가로 봅니다" // 5

//    null 불가
//    inferredNonNull = null                                   // 6

    fun strLength(notNull: String): Int {                    // 7
        return notNull.length
    }

    println(strLength(neverNull))                                      // 8
//    strLength(nullable)                                      // 9
}

fun describeString(maybeString: String?): String {           // 1
    if (maybeString != null && maybeString.length > 0) {     // 2
        return "문자열 길이 ${maybeString.length}"
    } else {
        return "Empty or null string"                        // 3
    }
}
