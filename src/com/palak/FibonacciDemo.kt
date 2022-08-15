package com.palak

import java.util.EnumSet.range

class FibonacciDemo {

    private val hashMap : HashMap<Int, Int> = hashMapOf()

    fun generate(limit : Int, useMemoization : Boolean) {
        for(i in 1..limit) {
            if(useMemoization){
                println(fibonacciUsingMemoization(i))
            }
            else{
                println(fibonacci(i));
            }
        }
    }

    private fun fibonacci(number : Int) : Int {

        if(number == 1 || number == 2) {
            return 1;
        }

        return fibonacci(number - 1) + fibonacci(number - 2)
    }

    fun fibonacciUsingLoop(number : Int) {

        var first = 1
        var sec = 1

        (1..number).forEach{ _ ->
            println(first)
            val next = first + sec
            first = sec
            sec = next
        }
    }

    private fun fibonacciUsingMemoization(number : Int) : Int {

        if (hashMap.containsKey(number)){
            return hashMap[number]!!
        }
        else {
            if(number == 1 || number == 2) {
                return 1;
            }

            val f = fibonacci(number - 1) + fibonacci(number - 2)
            hashMap[number] = f
            return f
        }
    }
}

fun main() {
    val f = FibonacciDemo()
    //f.generate(1000, false) //will take like forever for 1000.
    f.generate(5, false)
    println("---")
    f.fibonacciUsingLoop(5)
}