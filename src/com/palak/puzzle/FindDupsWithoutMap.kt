package com.palak.puzzle

fun main() {

    val i1 = intArrayOf(1,3,4,3,2,1)

    val f = FindDupsWithoutMap()

    f.findWithFrequencyArray(i1,5)

    f.findWithGroupingBy(i1)

    f.findWithHashMap(i1)
}
class FindDupsWithoutMap {

    fun findWithFrequencyArray(arr: IntArray, n: Int) {
        val frequencyArr = IntArray(n) { 0 }
        val dups = arrayListOf<Int>()

        for (element in arr) {
            if (element < n) {
                frequencyArr[element]++
            }
        }

        // frequencyArr --> index - 1 > fre - 0, index - 2 > fre - 1
        for (i in frequencyArr.indices) {
            if (frequencyArr[i] > 1) {
                dups.add(i)
            }
        }

        println("Dups: ")
        dups.forEach(::println)
    }

    //Extra -> with kotlin groupingBy
    fun findWithGroupingBy(arr: IntArray) {

        println("Dups with kotlin grouping: ")
        arr.toList().groupingBy { it }.eachCount().filter { it.value > 1 }.keys.forEach(::println)
    }

    //Extra -> with normal hashmap
    fun findWithHashMap(arr: IntArray) {
        val map = hashMapOf<Int, Int>() // Value, Freq

        for (element in arr) {
            if (map.containsKey(element)) {
                val count = map[element]!!
                map[element] = count+1
            } else {
                map[element] = 1
            }
        }
        println("Dups with hashmap: ")
        map.filter { it.value > 1 }.keys.forEach(::println)
    }
}