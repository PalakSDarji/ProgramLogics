package com.palak.kolin

import com.sun.org.slf4j.internal.Logger
import com.sun.org.slf4j.internal.LoggerFactory

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
        val LOG : Logger? = LoggerFactory.getLogger(Foo::class.java)
    }
}