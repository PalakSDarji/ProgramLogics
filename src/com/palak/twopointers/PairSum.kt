package com.palak.twopointers

class PairSum {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val resultArray = IntArray(2)
        nums.sort()
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