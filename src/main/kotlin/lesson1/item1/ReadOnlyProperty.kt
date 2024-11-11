package lesson1.item1

import java.util.SortedSet
import java.util.TreeSet

private fun readOnlyProperty() {
    val a = 10
//    a = 20 // 오류

    val list = mutableListOf(1,2,3)
    list.add(4)

    println(list) // [1, 2, 3, 4]
}

val name: String? = "Marton"
val surname: String = "Braun"

val fullName: String?
    get() = name?.let { "$it $surname" }
val fullName2: String? = name?.let { "$it $surname" }

fun main() {
    readOnlyProperty()

    if (fullName != null) {
//        println(fullName.length) // 오류
    }

    if (fullName2 != null) {
        println(fullName2.length)
    }
}
