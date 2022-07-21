package com.palak.kolin

import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class UserSingleton {
    companion object {

        @Volatile
        private var INSTANCE : UserSingleton? = null

        @JvmStatic
        public fun getInstance() : UserSingleton? {
            synchronized(UserSingleton::class){
                if(INSTANCE == null){
                    synchronized(UserSingleton::class){
                        println("in const from ${Thread.currentThread().name}")
                        INSTANCE = UserSingleton()
                    }
                }
            }
            return INSTANCE
        }
    }
}

fun main(): Unit = runBlocking {

    (1..100).forEach { _ ->
        launch {
            println("from ${Thread.currentThread().name} launch ${UserSingleton.getInstance()}")
        }
    }
}