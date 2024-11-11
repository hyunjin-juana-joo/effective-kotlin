package lesson1.item8

import lesson1.item1.User

val printer: Printer? = Printer("a")

fun main() {
//    printer.print() // 컴파일 오류
    printer?.print() // 안전호출
    if (printer != null) printer.print() // 스마트캐스팅
    printer!!.print() // non-null assertion

    val printerName1 = printer?.name ?: "Unnamed"
    val printerName2 = printer?.name ?: return
    val printerName3 = printer?.name ?: throw Error("Printer must be named")

    println("What's your name?")
    val name = readLine()
    if (!name.isNullOrBlank()) {
        println("Hello ${name.uppercase()}")
    }
}

// 오류를 강제로 발생시킬땐 throw, !!, requireNotNull, checkNotNull 등을 활용한다.
fun process(user: User) {
    requireNotNull(user.name)
    val context = checkNotNull(user.name)
}