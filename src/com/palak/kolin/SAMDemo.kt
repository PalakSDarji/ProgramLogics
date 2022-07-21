package com.palak.kolin

import java.util.concurrent.Executor
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import java.util.concurrent.ThreadPoolExecutor

fun main() {

    val isEven = object : IntPredicate {
        override fun accept(i: Int): Boolean {
            return true
        }
    }

    val isE = IntPredicate {
        true
    }

    val runnable = Runnable {

    }
    val executor : ExecutorService = Executors.newSingleThreadExecutor()

    executor.submit {

    }
}

fun interface IntPredicate {
    fun accept(i : Int) : Boolean
    fun aass(): Unit {

    }
}