package lesson1.item1

import kotlin.concurrent.thread
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

// 멀티 스레드
private fun multiThread() {
    var num = 0
    for (i in 1..1000) {
        thread {
            Thread.sleep(10)
            num += 1
        }
    }
    Thread.sleep(5000)
    println(num) // 1000이 아닐 확률이 매우 높음
    // 실행할 때마다 다른 숫자가 나온다.
}

// 코루틴
private suspend fun coroutine() {
    var num = 0
    coroutineScope {
        for (i in 1..1000) {
            launch {
                delay(10)
                num += 1
            }
        }
    }
    println(num) // 실행할 때마다 다른 숫자가 나온다.
}

suspend fun main() {
    multiThread()
    multiThread()
    coroutine()
    coroutine()
    locking()
    locking()
}

// 안전한 코드
private fun locking() {
    val lock = Any()
    var num = 0

    for (i in 1..1000) {
        thread {
            Thread.sleep(10)
            synchronized(lock) {
                num += 1
            }
        }
    }

    Thread.sleep(100)
    println(num) // 1000
}