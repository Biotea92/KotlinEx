package org.example.kotlin.`in`.action.`class`

import kotlinx.serialization.*
import kotlinx.serialization.json.*

interface JSONFactory<T> {
    fun fromJSON(jsonText: String): T

}

@Serializable
data class Person(val name: String) {
    object NameComparator : Comparator<Person> {
        override fun compare(p1: Person, p2: Person): Int =
            p1.name.compareTo(p2.name)
    }

    companion object : JSONFactory<Person> {
        override fun fromJSON(jsonText: String): Person =
            Json.decodeFromString(jsonText)
    }
}

fun main() {
//    val persons = listOf(Person("Bob"), Person("Alice"))
//    println(persons.sortedWith(Person.NameComparator))
    val person = Person.fromJSON(
        """
        {"name": "Dmitry"}
        """.trimIndent()
    )
    println(person)
}
