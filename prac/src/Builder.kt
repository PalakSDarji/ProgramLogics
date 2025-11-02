import java.util.Arrays

fun main() {
    val u = user {
        name = "palak"
        email = "emais3l"
    }
    val expr = Sum(Sum(Num(1), Num(2)), Num(3))
    println(eval(expr))
    val words = listOf("eat","tea","tan","ate","nat","bat")
    println(groupAnagrams(words))
    findSecondLargestNumber(intArrayOf(1,4,6,3,2))
    println(checkAnagram("listen", "silent"))
    println(checkAnagram("triangle", "integral"))
    println(checkAnagram("palakd", "palak"))
    findMissingNumberFromArrayInRange(intArrayOf(1,2,4,6,3,7,8),8)
    sortWithBubble(intArrayOf(3,5,2,7,1,6,8))
    println(findFirstNonRepeatedChar("palakp"))
    findCommonElementsInArr(arrayOf(1,2,3,4,5), arrayOf(4,5,6,7,8))
    countFreq(arrayOf("Apple","Banana","Apple","Orange"))
    countFreq(arrayOf(1,4,7,1,7))
    revWordsInSentence("Hi This is Palak")
    findPairsWithSum(intArrayOf(2,4,3,5,6,-1,8,7,1), 6)
    mergeSortedArr(intArrayOf(1,3,5,6), intArrayOf(2,4,7,8))
    println(mergeSort(intArrayOf(2,1,9,4,3,5)).joinToString(""))
    removeWhiteSpace("hi there  how")
    extractDigits("abc123def456ghi789")
}
data class User private constructor(
    val id: Int,
    val name: String,
    val email: String
) {
    class Builder {
        var id: Int = 0
        var name: String = ""
        var email: String = ""

        fun build() = User(id, name, email)
    }
}

fun user(block: User.Builder.() -> Unit): User {
    val builder = User.Builder()
    builder.block()
    return builder.build()
}

fun String.isPalindrome(): Boolean {
    val cleaned = this.replace("\\s".toRegex(), "").lowercase()
    return cleaned == cleaned.reversed()
}

sealed class Expr
data class Num(val value: Int): Expr()
data class Sum(val left: Expr, val right: Expr): Expr()

fun eval(expr: Expr): Int = when (expr) {
    is Num -> expr.value
    is Sum -> eval(expr.left) + eval(expr.right)
}

fun groupAnagrams(words: List<String>): List<List<String>> {
    return words.groupBy { it.toCharArray().sorted().joinToString("") }.values.toList()
}

fun findSecondLargestNumber(arr: IntArray) {
    var largest = Int.MIN_VALUE
    var secondLargest = Int.MIN_VALUE

    for (num in arr) {
        if (num > largest) {
            secondLargest = largest
            largest = num
        } else if (num > secondLargest && num != largest) {
            secondLargest = num
        }
    }
    println("Secondlargest: $secondLargest")
}

fun checkAnagram(s1: String, s2: String) : Boolean {
    val str1 = s1.replace("\\s","")
    val str2 = s2.replace("\\s","")

    if (str1.length != str2.length) return false
    return str1.toCharArray().sortedArray().contentEquals(str2.toCharArray().sortedArray())
}

fun findMissingNumberFromArrayInRange(arr: IntArray, n: Int) {
    //println((1..n).sum() - arr.sum())
    (1..n).forEach {
        if (!arr.contains(it)) {
            println("missed: $it")
        }
    }
}

fun sortWithBubble(input: IntArray) {
    for (i in input.indices) {
        for (j in 0 until input.size - i - 1) {
            if (input[j] > input[j + 1]) {
                val temp = input[j]
                input[j] = input[j + 1]
                input[j + 1] = temp
            }
        }
    }
    println(input.contentToString())
 //   arr.forEach(::println)
}

fun findFirstNonRepeatedChar(str: String) : Char? {
    /*val list = str.toCharArray().toList().groupingBy { it }.eachCount().filter { it.value == 1 }.keys
    if (list.isNotEmpty()) {
        println(list.first())
    } else {
        println("Not avail")
    }*/
    val map = linkedMapOf<Char, Int>()
    for (char in str.toCharArray()) {
        val count = map.getOrDefault(char, 0)
        map[char] = count+1
    }
    for (entry in map) {
        if (map[entry.key] == 1) {
            return entry.key
        }
    }
    return null
}

fun findCommonElementsInArr(arr1: Array<Int>, arr2: Array<Int>) {
    val common = arr1.intersect(arr2.toSet())
    println(common)
}

fun <T> countFreq(arr: Array<T>) {
    val map = arr.toList().groupingBy { it }.eachCount()
    map.forEach(::println)
}

fun revWordsInSentence(str: String) {
    //println(str.split(" ").reversed().joinToString(" "))
    val list = str.split(" ").toMutableList()
    var low = 0
    var high = list.lastIndex

    while (low < high) {
        val temp = list[high]
        list[high] = list[low]
        list[low] = temp
        low++
        high--
    }
    println(list.joinToString(" "))
}

// intArrayOf(2,4,3,5,6,-1,8,7,1), 6
fun findPairsWithSum(intArray: IntArray, target: Int) {
    val listOfPairs = arrayListOf<Pair<Int,Int>>()
    val setOfVisitedNumbers = mutableSetOf<Int>()

    for (i in intArray) {
        val complement = target - i
        if (setOfVisitedNumbers.contains(complement)) {
            listOfPairs.add(complement to i)
        }
        setOfVisitedNumbers.add(i)
    }
    println("size: ${listOfPairs.size}")
    listOfPairs.forEach {
        println("l: $it")
    }
}

fun mergeSortedArr(arr1: IntArray, arr2: IntArray) {
    val n1 = arr1.size
    val n2 = arr2.size
    val result = IntArray(n1+n2)

    var i = 0
    var j = 0
    var k = 0

    while (i < n1 && j < n2) {
        if (arr1[i] <= arr2[j]) {
            result[k++] = arr1[i++]
        } else {
            result[k++] = arr2[j++]
        }
    }

    while (i < n1) {
        result[k++] = arr1[i++]
    }
    while (j < n2) {
        result[k++] = arr2[j++]
    }

    result.forEach(::println)
}
/*

fun mergeSortedArr(arr1: IntArray, arr2: IntArray) {
    //val merged = (intArray1 + intArray2).sorted()
    //merged.forEach(::print)

    val n1 = arr1.size
    val n2 = arr2.size
    val result = IntArray(n1+n2)

    var i = 0
    var j = 0
    var k = 0

    while (i < n1 && j < n2) {
        if (arr1[i] <= arr2[j]) {
            result[k] = arr1[i]
            i++
            k++
        } else {
            result[k] = arr2[j]
            j++
            k++
        }
    }

    while (i < n1) {
        result[k] = arr1[i]
        i++
        k++
    }
    while (j < n2) {
        result[k] = arr2[j]
        j++
        k++
    }

    result.forEach(::println)
}
*/

fun mergeSort(arr: IntArray) : IntArray {
    if (arr.size <= 1) return arr

    val mid = arr.size / 2
    val left = mergeSort(arr.sliceArray(0 until mid))
    val right = mergeSort(arr.sliceArray(mid until arr.size))

    return merge(left, right)
}

fun merge(left: IntArray, right: IntArray): IntArray {
    val result = IntArray(left.size + right.size)
    var i = 0
    var j = 0
    var k = 0

    while (i < left.size && j < right.size) {
        if (left[i] <= right[j]) {
            result[k++] = left[i++]
        } else {
            result[k++] = right[j++]
        }
    }

    while (i < left.size) result[k++] = left[i++]
    while (j < right.size) result[k++] = right[j++]

    return result
}

fun removeWhiteSpace(str: String) {
    println(str.replace("\\s".toRegex(), ""))
}

fun extractDigits(str: String) {
    println(str.replace("[^0-9]".toRegex(),""))
}