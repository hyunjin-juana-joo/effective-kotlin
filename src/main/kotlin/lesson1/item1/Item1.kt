package lesson1.item1

import kotlin.concurrent.thread
import kotlin.properties.Delegates

// 변경할 수 있는 리스트
val list1: MutableList<Int> = mutableListOf() // mutable collection
var list2: List<Int> = listOf() // immutable collection + 프로퍼티 자체 변경 가능

var list = listOf<Int>()

var names by Delegates.observable(listOf<String>()) { _, old, new ->
    println("Names changed from $old to $new")
}

// 최악의 방식 이렇게 하지말것
var list3 = mutableListOf<Int>()

fun main() {
    list1.add(1)
    list2 = list2 + 1

    list1 += 1 // list1.plusAssign(1)
    list2 += 1 // list2 = list2.plus(1)


    for(i in 1..1000) {
        thread {
            list = list + i
        }
    }
    Thread.sleep(1000)
    println(list.size) // 1000이 아니며 실행할때마다 다른숫자나옴

    names += "Fabio"
    names += "Bill"

    list3 += 1
}