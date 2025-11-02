package com.palak.doublylinkedlist

fun main() {
    val dll = MyDoublyLinkedList(1)
    dll.getHead()
    dll.getTail()
    dll.printList()
    dll.getLength()

    dll.append(2)
    dll.getHead()
    dll.getTail()
    dll.printList()
    dll.getLength()

    println(dll.removeLast())

    dll.printList()

    println(dll.removeLast())
}

class MyDoublyLinkedList<T>(val value: T) {

    var length: Int = 0
    var head: Node<T>? = null
    var tail: Node<T>? = null

    init {
        val newNode = Node(value = value)
        head = newNode
        tail = newNode
        length++
    }

    fun append(value: T) {
        val newNode = Node(value = value)

        if (length == 0) {
            head = newNode
            tail = newNode
        } else {
            tail?.next = newNode
            newNode.prev = tail
            tail = newNode
        }
        length++
    }

    fun removeLast(): Node<T>? {
        if (length == 0) return null
        val lastNode = tail
        tail = lastNode?.prev
        tail?.next = null
        lastNode?.prev = null
        length--
        if (length == 0) {
            head = null
            tail = null
        }

        return lastNode
    }

    data class Node<T>(
        var value: T,
        var next: Node<T>? = null,
        var prev: Node<T>? = null,
    )

    fun getHead() {
        println("Head: ${head?.value}")
    }

    fun getTail() {
        println("Tail: ${tail?.value}")
    }

    fun getLength() {
        println("Length: $length")
    }

    fun getHeadNode() = head

    fun getTailNode() = tail

    fun printList() {
        var curr = head
        while (curr != null) {
            print("${curr.value} ")
            curr = curr.next
        }
        println()
    }
}