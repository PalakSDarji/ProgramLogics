package com.palak.kolin

class PairAndTriplePlay {

    fun getPair() = "a" to "B"

    fun getTriple() = Triple(1,2,3)
}

fun main() {
    val pairAndTriplePlay = PairAndTriplePlay()
    val (one : String, two : String) = pairAndTriplePlay.getPair()
    println(one)
    println(two)

    println(pairAndTriplePlay.getPair().toString())

    val triple = pairAndTriplePlay.getTriple()
    println(triple.first)
}