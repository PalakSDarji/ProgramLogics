package com.palak.kolin

class ScopeFunPlay {
    var person = Person("P")

    fun letPlay(){
        val i = person.let {
            it.name = "Android"
            4 // returns int.
        }
        println(person)
        println(i)
    }

    fun alsoPlay(){
        val p = person.also {
            it.name = "Hiya"
        }
        println(p)
    }

    fun runPlay(){
        val p = person.run {
            this.name = "Dhara"
            "random string"
        }
        println(p)
    }

    fun withPlay(){
        val p = with(person){
            this.name = "Suresh"
            "dd"
        }
        println(p)
    }

    fun applyPlay(){
        val p = person.apply {
            this.name = "Josh"
        }
        println(person)
        println(p)
    }
}

fun main() {
    val scopeFunPlay = ScopeFunPlay()
    scopeFunPlay.letPlay()
    scopeFunPlay.alsoPlay()
    scopeFunPlay.runPlay()
    scopeFunPlay.withPlay()
    scopeFunPlay.applyPlay()
}

data class Person(var name: String){
    val i : Int
    init {
        i = 3
    }
}