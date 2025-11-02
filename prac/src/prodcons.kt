import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import java.util.concurrent.ConcurrentHashMap

fun main() {
    runBlocking {
        /*val channel = Channel<Int>()
        launch {
            for (i in 1..10) {
                channel.send(i)
                delay(1000)
            }
            channel.close()
        }
        launch {
            for (num in channel) {
                println("Received: $num")
            }
        }*/
        /*try {
            val result = withTimeout(1000) {
                fakeApi()
            }
            println(result)
        } catch (e: TimeoutCancellationException) {
            println("API call timed out")
        }*/
        /*val cache = MyLRUCache<Int, String>(2)
        cache.put(1, "one")
        cache.put(2, "two")
        println(cache) // {1=one, 2=two}
        cache.get(2)   // Access 1
        cache.put(3, "three") // Removes 2
        println(cache) // {1=one, 3=three}*/
        val limiter = RateLimiter(5, 1000)
        repeat(10) {
            println("Request $it allowed: ${limiter.allow("user1")}")
        }
    }
}

suspend fun fakeApi(): String {
    delay(2000)
    return "asdas"
}

class MyLRUCache<K, V>(private val capacity: Int) {
    private val map = object : LinkedHashMap<K, V>(capacity, 0.75f, true) {
        override fun removeEldestEntry(eldest: MutableMap.MutableEntry<K, V>?): Boolean {
            return size > capacity
        }
    }

    fun get(key: K) = map[key]
    fun put(key: K, value: V) { map[key] = value }
    override fun toString(): String = map.toString()
}

class RateLimiter(private val maxRequests: Int, private val windowMillis: Long) {
    private val userRequests = ConcurrentHashMap<String, MutableList<Long>>()

    fun allow(user: String): Boolean {
        val now = System.currentTimeMillis()
        val requests = userRequests.computeIfAbsent(user) {
            mutableListOf()
        }
        synchronized(requests) {
            requests.removeIf { it < now - windowMillis }
            return if (requests.size < maxRequests) {
                requests.add(now)
                true
            } else false
        }
    }
}