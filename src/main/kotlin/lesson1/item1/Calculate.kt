package lesson1.item1

fun calculate(): Int {
    print("Calculationg... ")
    return 42
}

val fizz = calculate()
val buzz
    get() = calculate()

fun main() {
    println(fizz)
    println(fizz)
    println(buzz)
    println(buzz)
}