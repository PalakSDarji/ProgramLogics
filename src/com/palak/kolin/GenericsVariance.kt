package com.palak.kolin

fun main() {
    //useProducer(Case<Weapon>())//can't comple
    useProducer(Case<Rifle>())
    //useProducer(Case<SniperRifle>())//can't compile
}

fun useProducer(case : Case<Rifle>) = case.produce()

//fun useConsumer(case : Case<Rifle>) = case.consume(Weapon())//can't comple

class Case<out T>{
    private val contents = mutableListOf<T>()
    fun produce() : T = contents.last()
    //fun consume(item : T) = contents.add(item)//can't comple
}

open class Weapon
open class Rifle : Weapon()
class SniperRifle : Rifle()

