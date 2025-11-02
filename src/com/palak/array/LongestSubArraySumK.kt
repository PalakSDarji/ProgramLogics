package com.palak.array

fun main() {
    println(longestSubArraySumK(intArrayOf(10,5,2,7,1,9), 15))
}

fun longestSubArraySumK(nums: IntArray, k: Int): Int {

    val prefixSumMap = hashMapOf<Int, Int>() //sum, index
    var sum = 0
    var maxLen = 0

    for (i in nums.indices) {

        sum += nums[i]
        if (sum == k) {
            maxLen = i+1
        }
        if (!prefixSumMap.containsKey(sum)) {
            prefixSumMap[sum] = i
        }
        val remaining = sum - k
        if (prefixSumMap.containsKey(remaining)) {
            val prevIndex = prefixSumMap[remaining]!!
            maxLen = maxOf(maxLen, i - prevIndex)
        }
    }
    return maxLen
}
