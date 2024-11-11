package lesson1.item4

// inferred 타입
//open class Animal
//class Zebra: Animal()
//
//fun main() {
//    var animal = Zebra()
//    animal = Animal()
//}

// 명시적으로 지정하기
open class Animal
class Zebra: Animal()

fun main() {
    var animal: Animal = Zebra()
    animal = Animal()
}
