package com.palak.linkedlist

fun main() {
    val lruCacheManual = LRUCacheManual<Int, String>()
    println(lruCacheManual.get(1))
    lruCacheManual.put(1,"A")
    lruCacheManual.print()
    lruCacheManual.put(2,"B")
    lruCacheManual.print()
    lruCacheManual.put(3,"C")
    lruCacheManual.print()
    lruCacheManual.put(4,"D")
    lruCacheManual.print()
    lruCacheManual.put(5,"E")
    lruCacheManual.print()
    lruCacheManual.get(4)
    lruCacheManual.print()
    lruCacheManual.remove(5)
    lruCacheManual.print()
    lruCacheManual.remove(3)
    lruCacheManual.print()
    lruCacheManual.remove(3)
    lruCacheManual.print()
    lruCacheManual.remove(4)
    lruCacheManual.print()
}

class LRUCacheManual<K, V>(private val capacity: Int = 3) {

    data class Node<K, V>(
        var key: K,
        var value: V,
        var nextNode: Node<K, V>? = null,
        var prevNode: Node<K, V>? = null,
    )

    private val map = hashMapOf<K, Node<K, V>>()
    private var head: Node<K, V>? = null
    private var tail: Node<K, V>? = null

    fun print() {
        var curr = head
        println("---")
        while (curr != null) {
            print("${curr.key}, ${curr.value}, ${curr.prevNode?.key} , ${curr.nextNode?.key}")
            println()
            curr = curr.nextNode
        }
    }

    fun get(key: K) : V? {
        val node: Node<K, V>? = map[key]
        node?.let {
            moveToHead(it)
        }
        return node?.value
    }

    fun put(key: K, value: V) {
        val newNode = Node(key, value)
        map[key] = newNode
        if (map.size > capacity) {
            val lastKey = tail?.key
            map.remove(lastKey)
            tail = tail?.prevNode
            tail?.nextNode = null
        }
        addNodeToHead(newNode)
    }

    private fun moveToHead(node: Node<K, V>) {
        removeNode(node)
        addNodeToHead(node)
    }

    private fun addNodeToHead(node: Node<K, V>) {
        head?.prevNode = node
        node.nextNode = head
        node.prevNode = null
        head = node
        if (map.size == 1) {
            tail = node
        }
    }

    fun remove(key: K) {
        val node = map[key]
        node?.let {
            removeNode(node)
        }
    }

    private fun removeNode(node: Node<K, V>) {
        val prevNode = node.prevNode
        val nextNode = node.nextNode

        if (prevNode != null) {
            prevNode.nextNode = node.nextNode
        } else {
            head = node.nextNode
        }

        if (nextNode != null) {
            nextNode.prevNode = node.prevNode
        } else {
            tail = node.prevNode
        }
    }
}