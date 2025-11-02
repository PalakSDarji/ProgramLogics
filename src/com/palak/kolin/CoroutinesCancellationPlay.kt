package com.palak.kolin

import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class CoroutinesCancellationPlay {

}

fun main(): Unit = runBlocking {

    val supervisor = SupervisorJob()
    val supervisorScope = CoroutineScope(supervisor)
    val job = supervisorScope.launch {
        try {
            (1..10).forEach {
                delay(400)
                println(it)
                it / 0
            }
        } catch (e: Exception) {
            println("e: ${e.message}")
        }
    }

    val s = withContext(Dispatchers.IO){
        println("in withContext")
        (1..20).forEach {
            delay(400)
            println("withContext $it")
        }
        "ALl good"
    }

    println("performing stop")
    delay(2000)
    job.cancel()
    println("final message: $s")
    //job1.cancel()
    //System.exit(3)
}