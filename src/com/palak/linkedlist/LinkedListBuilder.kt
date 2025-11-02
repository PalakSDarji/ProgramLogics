package com.palak.linkedlist

fun main() {
    val linkedList = MyLinkedList(2)
    linkedList.append(3)
    linkedList.append(5)
    linkedList.printList()
    // println("Get: ${linkedList.get(-1)}") ERROR
    println("Get at 0: ${linkedList.get(0)}")
    println("Get: ${linkedList.get(1)}")
    println("Get: ${linkedList.get(2)}")
    linkedList.set(0, 10)
    linkedList.printList()
    linkedList.insert(2,11)
    linkedList.printList()
    // println("Get: ${linkedList.get(3)}") ERROR
    linkedList.removeLast()
    linkedList.removeLast()
    linkedList.removeLast()
    linkedList.removeLast()
    // println("Get: ${linkedList.get(0)}") ERROR
    linkedList.append(1)
    linkedList.prepend(4)
    println("removeFirst: ${linkedList.removeFirst()}")
    println("removeFirst: ${linkedList.removeFirst()}")
    linkedList.getHead()
    linkedList.getTail()
    linkedList.getLength()
    linkedList.printList()
    linkedList.append(100)
    linkedList.append(200)
    linkedList.append(300)
    linkedList.printList()
    linkedList.remove(2)
    linkedList.printList()
    linkedList.reverse()
    linkedList.printList()
}

class MyLinkedList<T>(value: T) {
    private var head: Node<T>? = null
    private var tail: Node<T>? = null
    var length: Int = 0

    init {
        val newNode = Node(value)
        head = newNode
        tail = newNode
        length = 1
    }

    private fun getNode(index: Int): Node<T>? {
        if (index < 0 || index >= length) throw ArrayIndexOutOfBoundsException("$index fetched with the size of $length")
        var curr = head
        repeat(index) {
            curr = curr?.next
        }
        return curr
    }

    // 1 -> 2 -> 3
    fun get(index: Int): T? {
        return getNode(index)?.value
    }

    fun set(index: Int, value: T): Boolean {
        val node = getNode(index)
        if (node != null) {
            node.value = value
            return true
        }
        return false
    }

    fun insert(index: Int, value: T): Boolean {
        if (index < 0 || index > length) return false
        if (index == 0) {
            prepend(value)
            return true
        }
        if (index == length) {
            append(value)
            return true
        }
        val newNode = Node(value)
        val prev = getNode(index - 1)
        newNode.next = prev?.next
        prev?.next = newNode
        length++
        return true
    }

    fun append(value: T) {
        val newNode = Node(value)
        if (length == 0) {
            head = newNode
            tail = newNode
        } else {
            tail?.next = newNode
            tail = newNode
        }
        length++
    }

    fun prepend(value: T) {
        val newNode = Node(value)
        if (length == 0) {
            head = newNode
            tail = newNode
        } else {
            newNode.next = head
            head = newNode
        }
        length++
    }

    fun removeFirst(): T? {
        if (length == 0) return null
        val curr = head
        head = head?.next
        curr?.next = null
        length--
        if (length == 0) {
            head = null
            tail = null
        } else if (length == 1) {
            tail = head
        }
        return curr?.value
    }

    fun removeLast(): T? {
        if (length == 0) return  null
        var curr = head
        var prev = head
        while (curr?.next != null) {
            prev = curr
            curr = curr.next
        }
        tail = prev
        tail?.next = null
        length--
        if (length == 0) {
            head = null
            tail = null
        }
        return tail?.value
    }

    fun remove(index: Int): T? {
        if (index < 0 || index >= length) return null
        if (index == 0) return removeFirst()
        if (index == length-1) return removeLast()

        val prev = getNode(index - 1)
        val curr = prev?.next

        prev?.next = curr?.next
        curr?.next = null
        length--

        return curr?.value
    }

    fun reverse() {
        var curr = head
        head = tail
        tail = curr
        var next: Node<T>? = null
        var prev: Node<T>? = null

        repeat(length) {
            next = curr?.next
            curr?.next = prev
            prev = curr
            curr = next
        }
    }

    class Node<T>(
        var value: T,
        var next: Node<T>? = null,
    )

    fun getHead() {
        println("Head: ${head?.value}")
    }

    fun getHeadNode() = head

    fun getTail() {
        println("Tail: ${tail?.value}")
    }

    fun getTailNode() = tail

    fun getLength() {
        println("Length: $length")
    }

    fun printList() {
        var curr = head
        while (curr != null) {
            print("${curr.value} ")
            curr = curr.next
        }
        println()
    }
}