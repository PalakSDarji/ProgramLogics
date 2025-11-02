package com.palak.twopointers

/*Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]
Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]

*/

fun main() {
    val nums1 = intArrayOf(2,7,11,15)
    val nums2 = intArrayOf(3,2,4)
    val nums3 = intArrayOf(3,3)

    val ps = TwoSum()

    // ps.twoSum(nums1, 9).print()
    ps.twoSumBruteForce(nums1, 9).print()
    ps.twoSumHashMap(nums1, 9).print()

    // ps.twoSum(nums2, 6).print()
    ps.twoSumBruteForce(nums2, 6).print()
    ps.twoSumHashMap(nums2, 6).print()

    // ps.twoSum(nums3, 6).print()
    ps.twoSumBruteForce(nums3, 6).print()
    ps.twoSumHashMap(nums3, 6).print()
}

public fun IntArray.print() {
    this.forEach(::println)
    println("-----")
}

class TwoSum {

    // Only apply on sorted array, when the index is not returned, but the actual element.
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val resultArray = IntArray(2)
        var left = 0
        var right = nums.lastIndex
        while (left < right) {
            val sum = nums[left] + nums[right]
            if (sum < target) {
                left++
            } else if (sum > target) {
                right--
            } else {
                resultArray[0] = left
                resultArray[1] = right
                return resultArray
            }
        }

        return resultArray
    }

    fun twoSumBruteForce(nums: IntArray, target: Int): IntArray {
        val resultArray = IntArray(2)
        for (i in 0 until nums.size) {
            for (j in i+1 until nums.size) {
                val sum = nums[i] + nums[j]
                if (sum == target) {
                    resultArray[0] = i
                    resultArray[1] = j
                    return resultArray
                }
            }
        }
        return resultArray
    }

    fun twoSumHashMap(nums: IntArray, target: Int): IntArray {
        val resultArray = IntArray(2)
        val sumMap = hashMapOf<Int, Int>() //element, index

        nums.forEachIndexed { index, element ->
            val complement = target - element
            if (sumMap.containsKey(complement)) {
                resultArray[0] = sumMap[complement]!!
                resultArray[1] = index
                return resultArray
            }
            sumMap[element] = index
        }
        return resultArray
    }
}