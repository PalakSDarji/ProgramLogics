package com.palak.kolin

import java.util.*

class ArrPlay {

    var arrOfStr : Array<String> = arrayOf("1","2")
    var intArray : IntArray = IntArray(3) //mutable
    var list : List<String> = listOf("s","t") // immutable.
    var mutableSet : MutableSet<String> = hashSetOf()

    fun play(){
        intArray[2] = 3

        intArray.forEach {
            println(it)
        }

        arrOfStr[1] = "3"

        mutableSet.add("1")
        mutableSet.add("1")

        println(mutableSet)
    }
}

fun main() {
    val arrPlay = ArrPlay()
    arrPlay.play()
}