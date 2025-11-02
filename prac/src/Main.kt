import java.util.Collections
import java.util.concurrent.Executors
import java.util.concurrent.LinkedBlockingQueue
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    //println(reverseString("Palak"))
    //println(reverseStringRecur("Palak"))
    //println(reverseStringManually("Palak"))
    //println(reverseOnlyLetters("Pal2a34k"))
    //simpleFunc()
    //val largerArray = IntArray(Int.MAX_VALUE)
    /*try {
        val i: String? = null
        println(i!!.length)
    } catch (e: NullPointerException) {

    }*/

    //val list = Collections.synchronizedList(arrayListOf<String>())

    //TaskProcessor()
    //findDuplicatesUsingMap(intArrayOf(1,3,4,4,2,1,3))
    //findDuplicatesUsingKotlin(intArrayOf(1,3,4,4,2,1,3))
    //findDuplicatesUsingSeen(intArrayOf(1,3,4,4,2,1,3))
    //findDuplicatesWithCount(intArrayOf(1,3,4,4,2,4,1,3))
    //findDuplicateGen(listOf("apple", "banana", "apple", "orange", "banana"))

    /*Person("asd","Aew")
    takeAny(Public(2))
    Animal()
    val ss = object : Fish() {
        override fun swim() {

        }
    }*/

    twoSum(intArrayOf(2,7,11,15), 26)
}

fun twoSum(nums: IntArray, target: Int): IntArray {
    val map = mutableMapOf<Int, Int>()
    for ((i, num) in nums.withIndex()) {
        val complement = target - num
        if (map.containsKey(complement)) {
            return intArrayOf(map[complement]!!, i)
        }
        map[num] = i
    }
    throw IllegalArgumentException("No solution")
}

fun twoSumm(nums: IntArray, target: Int): IntArray {
    val map = mutableMapOf<Int,Int>()
    nums.forEachIndexed { index, num ->
        val remaining = target - num
        if (map.containsKey(remaining)) {
            return intArrayOf(map[remaining]!!, index)
        }
        map[remaining] = index
    }
    throw IllegalArgumentException("No solution available")
}

class Testing {
    companion object {
        const val COMPILE_TIME_CONSTANT = "Hello"
        @JvmField
        var asdewe = 3
    }

    fun asd() {
        asdewe
        COMPILE_TIME_CONSTANT
    }
}
/*

open class Animal {
    open fun sound() = "Some sound"
    fun staticMethod() = "Animal static"  // Not overridable
}
class Dog : Animal() {
    override fun sound(): String {
        super.sound()
        return "Bark"
    }
}

abstract class Fish {
    abstract fun swim()
    open fun withBody() {

    }
}
class Dolphin : Fish() {
    override fun swim() {

    }

    override fun withBody() {
        super.withBody()
    }
}
*/

fun takeAny(obj: Any) {
    println((obj as Public).countw)
}

inline class Public(val countw: Int)

@JvmInline
value class Person(val name: String) {
    constructor(name: String, se: String) : this("Asd")
}

fun findDuplicatesUsingMap(arr: IntArray) {
    val map = mutableMapOf<Int,Int>()
    for (i in arr) {
        map[i] = map.getOrDefault(i, 0) + 1
    }
    val l = map.filter { it.value > 1 }.map { it.key }.toList()
    println(l)
}

fun findDuplicatesUsingKotlin(arr: IntArray) {

    println(arr.groupBy { it }.filter { it.value.size > 1 }.keys.toList())
    println(arr.toList().groupingBy { it }.eachCount().filter { it.value > 1 }.keys.toList())
}

fun findDuplicatesWithCount(array: IntArray) {
    println(array.toList().groupingBy { it }
        .eachCount())
        //.filter { it.value > 1 }
}

fun <T> findDuplicateGen(list: List<T>) {
    println(list.groupingBy { it }.eachCount().filter { it.value > 1 }.keys.toList())
}

fun findDuplicatesUsingSeen(arr: IntArray) {
    val seen = mutableSetOf<Int>()
    val duplicates = mutableSetOf<Int>()

    arr.forEach {
        if (it in seen) {
            duplicates.add(it)
        } else {
            seen.add(it)
        }
    }
    println(duplicates)
}

class TaskProcessor {
    private val queue = LinkedBlockingQueue<String>()
    private val producerExecutors = Executors.newFixedThreadPool(10)
    private val consumerExecutors = Executors.newFixedThreadPool(10)
    init {
        consumerExecutors.execute {
            (0..1000).forEach {
                addTask("str:$it")
            }
        }
        producerExecutors.execute {
            (0..1000).forEach { _ ->
                processTask()
            }
        }
    }

    fun addTask(str: String) {
        queue.offer(str)
    }
    fun processTask() {
        Thread {
            while (true) {
                try {
                    println(queue.take())
                } catch (e: InterruptedException) {
                    break
                }

            }
        }.start()
    }
}

fun reverseString(str: String) : String {

    val chars = str.toCharArray()
    var left = 0
    var right = chars.lastIndex

    while (left < right) {
        val temp = chars[left]
        chars[left] = chars[right]
        chars[right] = temp

        left++
        right--
    }

    return String(chars)
}

fun reverseStringRecur(str: String) : String {
    if (str.length <= 1) return str
    return reverseStringRecur(str.substring(1)) + str[0]
}

fun reverseStringFold(str: String): String {
    return str.fold("") { acc, char -> char + acc}
}

fun reverseStringManually(str: String): String {
    var result = ""
    for (i in str.length - 1 downTo 0) {
        result += str[i]
    }
    return result
}

fun reverseOnlyLetters(str: String): String {
    val chars = str.toCharArray()
    var left = 0
    var right = chars.size - 1

    while (left < right) {
        if (!chars[left].isLetter()) {
            left++
        } else if (!chars[right].isLetter()) {
            right--
        } else {
            val temp = chars[left]
            chars[left] = chars[right]
            chars[right] = temp
            left++
            right--
        }
    }

    return String(chars)
}

fun simpleFunc() {
    simpleFunc()
}