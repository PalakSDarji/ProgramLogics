package com.palak.linkedlist

fun main() {
    val ll = MyLinkedList(0)
    repeat(3) {
        ll.append(it+1)
    }
    ll.printList()
    println(FindKthNodeLL(ll).findFromStart(3))
    println(FindKthNodeLL(ll).findFromEnd(2))
}
class FindKthNodeLL<T>(val list: MyLinkedList<T>) {
    fun findFromEnd(k: Int): T? {
        if (list.getHeadNode() == null && list.getTailNode() == null) return null
        var slow: MyLinkedList.Node<T>? = list.getHeadNode()
        var fast: MyLinkedList.Node<T>? = list.getHeadNode()
        repeat(k) {
            if (fast == null) return null
            fast = fast?.next
        }
        while (fast != null) {
            slow = slow?.next
            fast = fast?.next
        }
        return slow?.value
    }

    // 0 index based
    fun findFromStart(k: Int): T? {
        if (k < 0) return null
        if (list.getHeadNode() == null && list.getTailNode() == null) return null
        var curr: MyLinkedList.Node<T>? = list.getHeadNode()
        repeat(k) {
            if (curr == null) return null
            curr = curr?.next
        }

        return curr?.value
    }
}