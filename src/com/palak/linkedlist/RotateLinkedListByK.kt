package com.palak.linkedlist

import java.util.LinkedList

fun main() {
    val linkedList = LinkedList<Int>()
    repeat(5) {
        linkedList.add(it)
    }
    println(linkedList.toString()) // [0, 1, 2, 3, 4]
    RotateLinkedListByK().rotateLinkedListByK(linkedList,1)
    println(linkedList.toString()) // [4, 0, 1, 2, 3]
/*

    val first = Node(1)
    val second = Node(2)
    val third = Node(3)
    second.next = third
    first.next = second

    printNodes(rotateCustomLinkedListByK(first, 1))*/
}

class RotateLinkedListByK() {
    fun <T> rotateLinkedListByK(linkedList: LinkedList<T>, k: Int) {
        val size = linkedList.size
        val mod = k % size // 2 % 5 = 2, but suppose k is 10, more than size -> gives index within size range.

        repeat(mod) {
            val lastNode = linkedList.removeLast()
            linkedList.addFirst(lastNode)
        }
    }

    // 0, 1, 2, 3  --- k = 2
    fun <T> rotateCustomLinkedListByK(head: Node<T>, k: Int) : Node<T>? {
        var newHead: Node<T>? = head
        var curr: Node<T>? = head
        var prev: Node<T>? = head
        var counterIndex = 1
        while(curr != null && counterIndex <= k) {
            prev = curr
            curr = curr.next
            counterIndex++
        }
        prev?.next = null
        newHead = curr

        var lastNode: Node<T>? = curr
        while (lastNode?.next != null) {
            lastNode = lastNode.next
        }
        lastNode?.next = prev

        return newHead
    }

    class Node<T>(val value: T, var next: Node<T>? = null)

    fun <T> printNodes(head: Node<T>?) {
        var curr: Node<T>? = head
        while (curr != null) {
            print("${curr.value} ")
            curr = curr.next
        }
        println()
    }
}
