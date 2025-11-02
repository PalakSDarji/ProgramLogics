import kotlin.math.sqrt

fun main() {

    /*for (i in 0 until 3) {
        println("i: $i")
    }*/

    val heights1 = intArrayOf(4, 2, 3, 1)
    val heights2 = intArrayOf(4, 3, 2, 1)
    val heights3 = intArrayOf(1, 3, 2, 4)

    //bubbleSort(intArrayOf(4,5,2,3,1))

    //println("Input: ${heights1.toList()}, Ocean view count = ${oceanView(heights1)}")
    // Buildings with ocean view: 4, 3, 1 → 3

    //println("Input: ${heights2.toList()}, Ocean view count = ${oceanView(heights2)}")
    // Buildings with ocean view: 4, 3, 2, 1 → 4

    //println("Input: ${heights3.toList()}, Ocean view count = ${oceanView(heights3)}")
    // Only last building (4) can see → 1

    //println(findFactorial(4))

    //countOccurrence("Palak")
    println(isPrime(4))
    println(sqrt(15f))
    sumOfDigits(12345)
    reverseDigits(12345)
    val s = removeDupFromArray(arrayOf(1,4,1,3,5,3))
    s.forEach {
        println(it)
    }
    revString("wed")
    findLength("palak")
    evenOddIndexElements(listOf("1","2","3","4"))
    println(ifArrSorted(arrayOf(1,2,3,4,5)))
    println(ifArrSorted(arrayOf(1,2,3,6,5)))
    caseLower("WrveR")
}

/*
fun oceanView(heights: IntArray) : Int {
    val n = heights.size
    var count = 0
    for (i in 0 until n) {
        var hasOceanView = true
        for (j in i+1 until n) {
            if (heights[j] >= heights[i]) {
                hasOceanView = false
                break
            }
        }
        if (hasOceanView) count++
    }
    return count
}*/

fun oceanView(heights: IntArray): Int {
    if (heights.isEmpty()) return 0
    var count = 0
    val result = mutableListOf<Int>()
    var maxHeightFromRight = 0

    for (i in heights.size - 1 downTo 0) {
        if (heights[i] > maxHeightFromRight) {
            count++
            result.add(i)
            maxHeightFromRight = heights[i]
        }
    }
    return count
}

fun bubbleSort(arr: IntArray) {
    val n = arr.size
    for (i in 0 until n) {
        for (j in 0 until n-i-1) {
            if (arr[j] > arr[j+1]) {
                val temp = arr[j]
                arr[j] = arr[j+1]
                arr[j+1] = temp
            }
        }
    }
    println("sorted: ${arr.toList()}")
}

// 0, 1, 2, 3, 4
fun binarySearch(arr: IntArray, target: Int) : Int {
    var low = 0
    var high = arr.size - 1
    while(low <= high) {
        val mid = low + (high - low) / 2
        when {
            arr[mid] == target -> return mid
            arr[mid] < target -> low = mid + 1
            arr[mid] > target -> high = mid - 1
        }
    }
    return -1
}
/*
* private long findFactorial(int number) {

        if(number == 0){
            return 1;
        }

        return number * findFactorial(number - 1);
    }
*/

fun findFactorial(number: Int) : Int {
    if (number == 0) return 1
    return number * findFactorial(number - 1)
}

fun fibonaci(n: Int) {
    var a = 0
    var b = 1

    print("$a $b")
    for (i in 2..n) {
        val c = a + b
        print("$c")
        a = b
        b = c
    }
}

fun countOccurrence(str: String) {
    val s = str.toCharArray().toList().groupingBy { it }.eachCount().maxBy { it.value }.key
    println(s)
}

fun isPrime(number: Int): Boolean {
    if (number <= 1) return false
    var isPrime = true
    for (i in 2..sqrt(number.toDouble()).toInt()) {
        if (number % i == 0) {
            isPrime = false
            break
        }
    }
    return isPrime
}

fun sumOfDigits(number: Int) {
    var n: Int = number
    var sum = 0
    while (n > 0) {
        val m = n % 10
        sum += m
        n /= 10
    }
    println("sum: $sum")
}

fun reverseDigits(number: Int) {
    var n: Int = number
    var sum = ""
    while (n > 0) {
        val m = n % 10
        sum += m
        n /= 10
    }
    println("reverse: $sum")
}

inline fun <reified T> removeDupFromArray(arr: Array<T>): Array<T> {
    return arr.toSet().toTypedArray()
}

fun revString(str: String) {
    val c = str.toCharArray()
    var low = 0
    var high = c.lastIndex
    while (low < high) {
        val temp = c[high]
        c[high] = c[low]
        c[low] = temp
        low++
        high--
    }
    val s: String = c.joinToString("")
    println(s)
}

fun findLength(s: String) {
    var l = 0
    try {
        while (true) {
            s[l]
            l++
        }
    } catch (e: StringIndexOutOfBoundsException) {

    } finally {
        println(l)
    }
}

fun evenOddIndexElements(list: List<String>) {
    for (i in 1..list.size step 2) {
        println("Even: $i")
    }
}

fun ifArrSorted(arr: Array<Int>) : Boolean {
    var sorted = true
    for (i in 0 until arr.lastIndex) {
        if (arr[i] > arr[i+1]) {
            sorted = false
            break
        }
    }
    return sorted
}

fun caseLower(str: String) {
    val chars = str.toCharArray()
    var lowerCase = ""
    for (c in chars) {
        if (Character.isUpperCase(c)) {
            lowerCase += c.plus(32)
        } else {
            lowerCase += c
        }
    }
    println("lower: $lowerCase")
}

fun reverseList(head: ListNode?): ListNode? {
    var prev: ListNode? = null
    var curr: ListNode? = head
    var next: ListNode? = null
    while (curr != null) {
       next = curr.next
       curr.next = prev
       prev = curr
       curr = next
    }
    return prev
}