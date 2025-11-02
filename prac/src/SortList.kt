import java.util.*

fun main() {
    val m = MergeSortList().mergeSort(intArrayOf(3,5,1,0,9,6,4))
    println("size: ${m.size}")
    m.forEach(::println)
}

class MergeSortList {

    fun mergeSort(arr: IntArray): IntArray {
        if (arr.size <= 1) return arr
        val mid = arr.size / 2
        val left = mergeSort(arr.sliceArray(0 until mid))
        val right = mergeSort(arr.sliceArray(mid until arr.size))
        return merge(left, right)
    }

    private fun merge(left: IntArray, right: IntArray): IntArray {
        val n1 = left.size
        val n2 = right.size
        val result = IntArray(n1 + n2)
        var i = 0
        var j = 0
        var k = 0

        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                result[k++] = left[i++]
            } else {
                result[k++] = right[j++]
            }
        }

        while (i < n1) {
            result[k++] = left[i++]
        }
        while (j < n2) {
            result[k++] = right[j++]
        }

        return result
    }
}