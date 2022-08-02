package com.palak.kolin

fun main() {

    val list = listOf(1,2,3,3)

    val sum = list.fold(3){ x,y->
        x + y
    }
    println(sum)

    val sumReduce = list.reduce{ x, y->
        x + y
    }
    println(sumReduce)

    println(list.distinct())

    println(Palak("As"))
}

data class Palak(private val id: Int, private val name: String){
    constructor(name: String) : this(0,name)
}