package com.palak.linkedlist

fun main() {
    val ll = MyLinkedList<Int>(0)
    repeat(3) {
        ll.append(it+1)
    }
    ll.printList()
    println(FindMiddleNodeLL(ll).find())
}
class FindMiddleNodeLL<T>(val list: MyLinkedList<T>) {

    fun find() : T? {
        var slow = list.getHeadNode()
        var fast = list.getHeadNode()

        while (fast?.next != null) {
            slow = slow?.next
            fast = fast.next?.next
        }

        return slow?.value
    }
}