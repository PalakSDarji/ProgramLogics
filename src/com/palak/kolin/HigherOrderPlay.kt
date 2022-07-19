package com.palak.kolin

val thisIsFunc : (Int)-> Unit = { x ->
    println("print $x")
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
}