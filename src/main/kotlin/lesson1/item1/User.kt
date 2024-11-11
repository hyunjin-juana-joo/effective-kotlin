package lesson1.item1

data class User(
    val name: String,
    val surname: String,
) {
    fun withSurname(surname: String): User = User(name, surname)
}

class UserRepository {
    private val storedUsers: MutableMap<Int, String> = mutableMapOf()

    fun loadAll(): MutableMap<Int, String> {
        return storedUsers
    }
}

fun main() {
    var user = User("Hyunjin", "Joo")
    user = user.withSurname("Ju")
    println(user) // Hyunjin Ju

    var user2 = User("Hyunjin", "Joo")
    user2 = user.copy(surname = "Ju")
    println(user2)  // Hyunjin Ju

    // loadAll을 통해 priviate 상태인 userRepository를 수정할 수 있음
    val userRepository = UserRepository()
    val storedUsers = userRepository.loadAll()
    storedUsers[4] = "Kiraill"
}