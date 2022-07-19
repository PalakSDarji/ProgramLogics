package com.palak.kolin
import kotlinx.coroutines.*

import javax.script.ScriptContext
import kotlin.coroutines.CoroutineContext
import kotlin.system.measureTimeMillis

class CoroutinesPlay {

    fun doSomething(){


    }
}

suspend fun doThis(){


}

/*fun main() = runBlocking {
    val job = launch {
        delay(3000)
        println("world")
    }
    job.cancelAndJoin()
    print("hello")
}*/

fun main() = runBlocking {
    val time = measureTimeMillis {
        val one = async { doSomethingUsefulOne() }
        val two = async { doSomethingUsefulTwo() }
        println("The answer is ${one.await() + two.await()}")
    }
    println("Completed in $time ms")
}


suspend fun doSomethingUsefulOne(): Int {
    return withContext(Dispatchers.IO){
        delay(1000L) // pretend we are doing something useful here
        13
    }
}

suspend fun doSomethingUsefulTwo(): Int {
    delay(1000L) // pretend we are doing something useful here, too
    return 29
}