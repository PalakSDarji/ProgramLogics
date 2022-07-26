package com.palak.kolin


inline fun <reified T> genericsExample(value: T) {
    println(value)
    println("Type of T: ${T::class.java}")
    println("Type of T: ${value!!::class.java}")
}

fun main() {
    genericsExample<String>("Learning Generics!")
    genericsExample<Int>(100)
}

class Foo {
    companion object{

    }
}