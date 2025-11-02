
fun main() {
    swapWithXor()
    swapWithPlus()
    swapWithMultiply()
}

fun swapWithXor() {
    var a = 10
    var b = 20

    a = a xor b
    b = a xor b
    a = a xor b

    println("a: $a, b: $b")
}

fun swapWithPlus() {
    var a = 10
    var b = 20

    a = a + b // 30 20
    b = a - b // 30 - 20 = 10
    a = a - b //30 - 10 = 20

    println("a: $a, b: $b")
}

fun swapWithMultiply() {
    var a = 10
    var b = 20

    a = a * b // 10 * 20 = 200
    b = a / b // 200 / 20 = 10
    a = a / b // 200 / 10 = 20

    println("a: $a, b: $b")
}