package com.palak.array

fun main() {
    val arr = intArrayOf(900, 940, 950, 1100, 1500, 1800)
    val dep = intArrayOf(910, 1200, 1120, 1130, 1900, 2000)
    println(findMaxTrainPlatformGreedy(arr, dep))
}

fun findMaxTrainPlatformGreedy(arr: IntArray, dep: IntArray): Int {
    arr.sort()
    dep.sort()
    var i = 0
    var j = 0
    var platform = 0
    var maxPlatform = 0
    val size = arr.size

    while (i < size && j < size) {
        if (arr[i] <= dep[j]) {
            platform++
            i++
        } else {
            platform--
            j++
        }
        maxPlatform = maxOf(maxPlatform, platform)
    }

    return maxPlatform
}