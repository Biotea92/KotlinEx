package org.example.kotlin.`in`.action.`class`

import org.example.Person

object Payroll {
    val allEmployees = arrayListOf<Person>()

    fun calculateSalary() {
        for (person in allEmployees) {
            // ...
        }
    }
}
