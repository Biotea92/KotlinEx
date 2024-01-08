package org.example.collections

data class Person(val name: String, val city: String, val phone: String) // 1

fun toMap() {
    val people = listOf(                                                     // 2
        Person("석구", "서울", "02-1234-5678"),
        Person("성태", "부산", "051-234-9876"),
        Person("효리", "제주", "064-123-4567"),
        Person("상순", "제주", "064-234-8901")
    )
    println("people = ${people}")

    val phoneBook = people.associateBy { it.phone }                          // 3
    println("phoneBook = ${phoneBook}")
    val cityBook = people.associateBy(Person::phone, Person::city)           // 4
    println("cityBook = ${cityBook}")
    val peopleCities = people.groupBy(Person::city, Person::name)            // 5
    println("peopleCities = ${peopleCities}")
    val lastPersonCity = people.associateBy(Person::city, Person::name)      // 6
    println("lastPersonCity = ${lastPersonCity}")
}

fun main() {
    toMap()
}
