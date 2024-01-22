package org.example.kotlin.`in`.action.`class`

class DelegatingCollection<T> (
    innerList: Collection<T> = ArrayList<T>()
) : Collection<T> by innerList
