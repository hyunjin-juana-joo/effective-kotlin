package lesson1.item2

import lesson1.item1.User

val a = 1
fun fizz() {
    val b = 2
    println(a + b)
}

val buzz = {
    val c = 3
//    println(a + c) // a는 사용할 수 있으나 b,c는 사용불가
}

val users = listOf<User>()
//var user: User

// bad
//fun updateWeather(degrees: Int) {
//    val description: String
//    val color: String
//    if (degrees < 5) {
//        description = "cold"
//        color = "BLUE"
//    } else if (degrees < 23) {
//        description = "mild"
//        color = "YELLOW"
//    } else {
//        description = "hot"
//        color = "RED"
//    }
//}

// good
fun updateWeather(degrees: Int) {
    val (description, color) = when {
        degrees < 5 -> "color" to "BLUE"
        degrees < 23 -> "mild" to "YELLOW"
        else -> "hot" to "RED"
    }
}

fun main() {
    // 외부/내부 모두 사용할 수 있는 변수 사용
//    for (i in users.indices) {
//        user = users[i]
//        println("User at $i is $user")
//    }

    // user 스코프를 내부로 제한
    for (i in users.indices) {
        val user = users[i]
        println("User at $i is $user")
    }

    for ((i, user) in users.withIndex()){
        println("User at $i is $user")
    }

    updateWeather(25)

//    var numbers = (2..100).toList()
//    val primes = mutableListOf<Int>()
//
//    while (numbers.isNotEmpty()) {
//        val prime = numbers.first()
//        primes.add(prime)
//        numbers = numbers.filter { it % prime != 0 }
//    }
//    println(primes)

    val primes: Sequence<Int> = sequence {
        var numbers = generateSequence(2) { it + 1 }

        while (true) {
            val prime = numbers.first()
            yield(prime)
            numbers = numbers.drop(1)
                .filter {
                    it % prime != 0
                }
        }
    }
    println(primes.take(10).toList()) // [2, 3, 5, 7. 11, 13, 17, 19, 23, 29]

    // 안좋은 예
//    val primes: Sequence<Int> = sequence {
//        var numbers = generateSequence(2) { it + 1 }
//        var prime: Int
//        while (true) {
//            prime = numbers.first()
//            yield(prime)
//            numbers = numbers.drop(1)
//                .filter {
//                    it % prime != 0
//                }
//        }
//    }
//    println(primes.take(10).toList()) // [2, 3, 5, 6, 7, 8, 9, 10, 11, 12]
}