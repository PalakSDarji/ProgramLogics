package com.palak.kolin

fun main() {

    var colors: List<String> = listOf("Red", "Orange","Yellow","Blue","Green","Indigo","Violet")

    val pair = colors.partition {
        it.equals("Red")
    }
    println(pair.first)
    println(pair.second)

    val s = sequenceOf(1,2,3)
    val map = s.associateBy {
        "$it"
    }

    val name = Username("Palak")
    name.doCertain()
    doAdd(3,{
        print("Hello $it")
    },{
        println("Hi $it")
    })

    val list = listOf<List<Int>>(listOf(1,2,3), listOf(4,5,6))
    list.map {
        println(it)
    }
    println("---")
    list.flatMap {
        println(it)
        it
    }.map {
        println(it)
    }
}

inline fun doAdd(i : Int, noinline  f1 : (Int)-> Unit,  f2 : (Int)-> Unit){
    val mul = i * i
    f1(mul)
    f2(mul)
}

inline class Username(private val userName: String){
    fun doCertain(){
        println(userName)
    }
}

internal class Sam(@JvmField var c : Int){
    @JvmOverloads
    fun m1(a: Int? = null,b : String? = null){

    }

    init {
        m1()
    }
}