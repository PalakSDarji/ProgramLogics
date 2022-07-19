package com.palak.kolin

fun main() {

    //println(Sub().i) cant use.
}

class AccessModifierPlay {

}

open class Super{
    protected open var i : Int = 0
}

class Sub : Super() {
    //override private var i : Int = 2;..can't compile
}