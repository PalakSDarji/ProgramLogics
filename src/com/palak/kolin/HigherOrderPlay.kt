package com.palak.kolin

import java.util.stream.Collector
import org.junit.Assert.assertEquals

val thisIsFunc : (Int)-> Unit = { x ->
    println("print $x")
    assertEquals("A","A")
}

fun higherOrderFunc(thisIsFun : (Int)-> Unit){
    thisIsFun.invoke(3)
}

fun anotherHigherOrderFunc(func : () -> Int){
    val i = func()
    println("print $i")
}

fun anotherHigherOrderFunc(func1 : () -> Int, func2 : (Int,Int) -> Int) : Int{
    val i = func1()
    val j = func2(2,3)
    println("print i $i, print j $j")
    return i * j
}

fun main() {

    val p : Person? = null
    println(p?.child?.name ?: "nope")

    higherOrderFunc(thisIsFunc)
    anotherHigherOrderFunc {
        4
    }

    val k = anotherHigherOrderFunc({
        3
    }, {x,y->
        x*y
    })

    println("k : $k")
    doProcess(multiplyFunction())
    doProcess(sumFunction)
    val (m,v) = M(2,3)
    println(m)
    println(v)

    val rawString = """T\nhis @ is ! - 0))(({""}""""
    println(rawString)//T\nhis @ is ! - 0))(({""}"
    val escapeString = "T\n@ is ! - 0}P(\""
    println(escapeString)//T
    //@ is ! - 0}P("

    when(2){
        2 -> println("As")
        else -> {

        }
    }

    val maggie = Maggie(4,2)

    for(c in 1 until 4){
        println(c)
    }

    var a = "A"
    var b = "C"
    println(a === b)
    println(a.doExtra())
}

fun doProcess(func : (Int)->Unit) {
    func.invoke(2)
}

fun multiplyFunction(): (Int) -> Unit {
    return {
        it * it
    }
}

var sumFunction : (Int) -> Unit = {
    it + it

}

private open class Noodle(private val color : Int) {
    constructor(color : Int, pro : Int) : this(color)
    init {
        println("init noodle")
    }
}

private class Maggie(private var color : Int) : Noodle(color){
    constructor(color : Int, pro : Int) : this(color){
        this.color = 3
    }
    init {
        println("init maggie")
    }
}

private data class M(val a : Int, val b : Int){
    constructor(a : Int) : this(a,0)
    init {

    }
}

private fun String.doExtra() : String{
    this.plus(" Do")
    return this
}