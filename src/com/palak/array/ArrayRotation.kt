package com.palak.array

fun main() {
    val ar = ArrayRotation(intArrayOf(1,2,3,4,5,6,7))
    ar.rotateArrayInPlace(k = 3).forEach(::print)

    println()

    val ar1 = ArrayRotation(intArrayOf(1,2,3,4,5,6,7))
    ar1.rotateViaArrayList(k = 3).forEach(::print)
}

class ArrayRotation(private val intArray: IntArray) {

    private val size = intArray.size

    fun rotateArrayInPlace(k: Int): IntArray {
        val shift = k % size
        rotate(0, size-1)
        rotate(0, shift-1)
        rotate(shift, size-1)
        return intArray
    }

    private fun rotate(i: Int, j: Int) {
        var start = i
        var end = j
        while (end > start) {
            val temp = intArray[end]
            intArray[end] = intArray[start]
            intArray[start] = temp
            start++
            end--
        }
    }

    fun rotateViaArrayList(k: Int): IntArray {
        val list = intArray.toMutableList()
        val first = list.subList(0, k+1)
        val second = list.subList(k+1, list.size)
        val updated = second + first
        return updated.toIntArray()
    }
}