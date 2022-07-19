package com.palak.kolin

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

class FlowPlay {


}

fun main() {

    val mutableSharedFlow : MutableSharedFlow<String> = MutableSharedFlow()
    val sharedFlow : SharedFlow<String> = mutableSharedFlow

    runBlocking {
        launch {
            (1..5).forEach {
                mutableSharedFlow.emit(it.toString())
                delay(1000)
                println("emitting")
            }
        }

        launch {
            sharedFlow.collect {
                println("Reading" +it)
            }
        }
        launch {
            sharedFlow.collect {
                println("Reading" +it)
            }
        }
    }
/*
    val flowSimple : Flow<String> = flow<Int> {
        (1..5).forEach {
            emit(it)
            println("emiting : $it")
        }
    }.map {
        it.toString()
        println("inside map: "+ Thread.currentThread().name)
    }.transform {
        emit("Hi $it")
    }.flowOn(Dispatchers.IO)


    runBlocking {
        flowSimple.conflate().collect {
            println(it)
            delay(1000)
        }
        flowSimple.take(2).collect {
            println(it)
        }
    }*/




}