package org.example.kotlin.`in`.action.lambda


fun main() {

    val people = listOf(Person("Alice", 29), Person("Bob", 31))

    // filter와 map이 리스트를 반환하여 연쇄 호출이 리스트 2개를 만든다.
    people.map(Person::name).filter { it.startsWith("A") }

    // 효율적으로 만들기 위해 각 연산이 컬렉션을 직접 사용하는 대신 시퀀스를 사용하게 만들어야 한다.
    people.asSequence()
        .map(Person::name)
        .filter { it.startsWith("A") }
        .toList()
    // 중간 연산은 항상 계산이 지연된다.
    // 최종연산이 없으면 중간 연산이 적용되지 않는다.

    println("최종연산이 없는 경우")
    listOf(1, 2, 3, 4).asSequence()
        .map { print("map($it)"); it * it }
        .filter { print("filter($it)"); it % 2 == 0 }

    println("최종연산이 있는 경우")
    listOf(1, 2, 3, 4).asSequence()
        .map { print("map($it)"); it * it }
        .filter { print("filter($it)"); it % 2 == 0 }
        .toList()

    println()
    println(listOf(1,2,3,4).asSequence().map { it * it }.find { it > 3 })

    val peoples = listOf(Person("Alice", 29), Person("Bob", 31), Person("Charles", 31), Person("Dan", 21))
    println(peoples.asSequence().map(Person::name)
        .filter { it.length < 4 }.toList())
    println(peoples.asSequence().filter { it.name.length < 4 }
        .map(Person::name).toList())

    val naturalNumbers = generateSequence(0) { it + 1 }
    val numbersTo100 = naturalNumbers.takeWhile { it <= 100 }
    println(numbersTo100.sum())
}
