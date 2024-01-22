package org.example.kotlin.`in`.action.`class`

class Outer {
    inner class Inner {
        fun getOuterReference(): Outer = this@Outer
    }
}
