package com.palak.linkedlist

fun main() {
    val ll = MyLinkedList<Int>(0)
    repeat(3) {
        ll.append(it+1)
    }
    ll.printList()
    println(FindHasLoopLL(ll).hasLoop())
}

class FindHasLoopLL<T>(val list: MyLinkedList<T>) {

    fun hasLoop(): Boolean {
        var slow = list.getHeadNode()
        var fast = list.getHeadNode()

        while (fast?.next != null) {
            slow = slow?.next
            fast = fast.next?.next

            if (slow == fast) {
                return true
            }
        }

        return false
    }
}