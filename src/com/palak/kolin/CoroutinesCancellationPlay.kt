package com.palak.kolin

import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class CoroutinesCancellationPlay {

}

fun main(): Unit = runBlocking {

    val job = launch {
        (1..100).forEach {
            delay(400)
            println(it)
        }
    }

        val s = withContext(Dispatchers.IO){
            println("in withContext")
            (1..100).forEach {
                delay(400)
                println("withContext $it")
            }
            "ALl good"
        }



    println("performing stop")
    delay(2000)
    //job.cancel()
    //job1.cancel()
    //System.exit(3)
}