package com.palak.linkedlist

class ReverseBetweenLL(val list: MyLinkedList<Int>)  {

    // Returns updated head
    fun reverseBetween(startIndex: Int, endIndex: Int): MyLinkedList.Node<Int>? {
        val dummyStart = MyLinkedList.Node(value = -1)
        dummyStart.next = list.getHeadNode()

        var prev : MyLinkedList.Node<Int>? = dummyStart
        (0 until startIndex).forEach {
            prev = prev?.next
        }
        val curr : MyLinkedList.Node<Int>? = prev?.next
        (0 until endIndex-startIndex).forEach {
            val nodeToMove = curr?.next
            curr?.next = nodeToMove?.next
            nodeToMove?.next = prev?.next
            prev?.next = nodeToMove
        }

        return dummyStart.next
    }
}