
val arrayDeque = ArrayDeque<Char>()
val hash = mapOf(
    ')' to '(',
    ']' to '[',
    '}' to '{',
)

fun main() {
    println(ArrayDequeEx1().isValid("([])"))
    println(ArrayDequeEx1().isValid("([]{)"))
}
class ArrayDequeEx1 {
    fun isValid(s: String): Boolean {
        for (char in s) {
            if (char in hash.keys) {
                if (arrayDeque.isNotEmpty() && arrayDeque.last() == hash[char]) {
                    arrayDeque.removeLast()
                } else {
                    return false
                }
            }
            else {
                arrayDeque.addLast(char)
            }
        }

        return arrayDeque.isEmpty()
    }
}