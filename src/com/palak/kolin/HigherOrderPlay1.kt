package com.palak.kolin

fun main() {
    val func = higherOrder1()
    func(9)

    higherOrder2 {
        println("it: $it")
    }

    higherOrder3 {
        3
    }

    val r = "Asd"
    r.let {

    }
    r.also {

    }
    r.run {

    }
    with(r) {

    }
    r.apply {

    }
}

fun higherOrder1() : (Int)-> Unit {
    return {}
}

fun higherOrder2(func : (Int) -> Unit) {
    func(3)
}

fun higherOrder3(func : () -> Int) {
    val returned = func()
}