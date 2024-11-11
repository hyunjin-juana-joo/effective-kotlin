package lesson1.item5

import com.sun.tools.javac.jvm.ByteCodes.ret
import lesson1.item1.User

class Stack<T>(
    var collection: List<T>
) {
    private val size = 3
    private val isOpen = false

    fun pop(num: Int = 1): List<T> {
        require(num <= size) {
            "Cannot remove more elements than current size"
        }
        check(isOpen) { "Cannot pop from closed stack" }
        val ret = collection.take(num)
        collection = collection.drop(num)
        assert(ret.size == num)
        return ret
    }
}

fun factorial(n: Int): Long {
    require(n >= 0)
    return if (n <= 1) 1 else factorial(n - 1) * n
}

//fun findClusters(points: List<Point>): List<Cluster> {
//    require(points.isNotEmpty())
//    //...
//    return points.map { Cluster() }
//}
//
//fun sendEmail(user: User, message: String) {
//    requireNotNull(user.email)
//    require(isValildEmail(user.email))
//}

// 상태와 관련된 제한을 걸때 일반적으로 check 함수 사용
//fun speak(text: String) {
//    check(text)
//    // ...
//}

// 구현문제로 발생할 수 있는 추가적인 문제를 예방하려면 단위 테스트 사용하는게 좋음
//fun pop(num: Int = 1): List<T> {
//    assert(ret.size == num)
//    return ret
//}

// 스마트 캐스팅 예시
//fun changeDress(person: Person) {
//    require(person.outfit is Dress)
//    val dress: Dress = person.outfit
//    //...
//}

// nullability 예시
//fun sendEmail(person: Person, text: String) {
//    val email: String = person.email ?: return
//}

