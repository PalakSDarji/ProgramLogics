package com.palak

import kotlin.math.sqrt

//2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47,
//53, 59, 61, 67, 71, 73, 79, 83, 89, 97.
class PrimeFinder {

    fun fetchPrime(number: Int) {
        for(i in 1..number){
            if(checkPrime(i)){
                print("$i ")
            }
        }
    }

    private fun checkPrime(number : Int) : Boolean {
        if(number == 1 || number == 2) return false

        var isPrime = true

        for(i in 2..sqrt(number.toDouble()).toInt()){
            if(number % i == 0){
                //if divisible by 2 or more up to sqrt of the number, reminder will not be 0.
                // In that case, number is not prime. otherwise its prime.
                isPrime = false
            }
        }

        return isPrime
    }
}

fun main() {
    PrimeFinder().fetchPrime(100)
}