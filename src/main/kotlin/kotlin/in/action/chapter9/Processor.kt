package org.example.kotlin.`in`.action.chapter9

class Processor<T : Any> {
    fun process(value: T) {
        value.hashCode()
    }
}
