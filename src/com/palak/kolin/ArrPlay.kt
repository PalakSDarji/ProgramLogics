package com.palak.kolin

import java.util.*

typealias UserName = String
typealias Pass = String

class ArrPlay {

    var arrOfStr : Array<String> = arrayOf("1","2")
    var intArray : IntArray = IntArray(3) //mutable
    var list : List<String> = listOf("s","t") // immutable.
    var mutableSet : MutableSet<String> = hashSetOf()

    fun play(){

        arrOfStr.distinct()

        intArray[2] = 3

        intArray.forEach {
            println(it)
        }

        arrOfStr[1] = "3"

        mutableSet.add("1")
        mutableSet.add("1")

        println(mutableSet)

        val list = mutableListOf(1,2,3,4)
        val map = list.associateBy {
            "s$it"
        }

        val user : UserName = "Asd"
        val pass : Pass = "pass"
        auth(user,pass)
        auth1(UserClass("us"),PassClass("ps"))
        findElement(listOf(2,3,"As"))
        findElement(mutableListOf(2,3,"As"))
        findElement(arrayListOf(2,3,"As"))
    }

    private fun auth(username: UserName, pass: Pass){

    }

    private fun auth1(username: UserClass, pass: PassClass){

    }

    inline class UserClass(val userName: String)
    inline class PassClass(val pass: String)
}

fun findElement(arr: List<*>){

}
fun main() {
    val arrPlay = ArrPlay()
    arrPlay.play()
}
class Student(var id: String, var name: String){
    constructor(id: String) : this(id,"")
    init {
        defineStatic()
    }
}

fun defineStatic(){
    println("this is static function without companion object.")
}