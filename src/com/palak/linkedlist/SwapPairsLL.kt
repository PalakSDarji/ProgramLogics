package com.palak.linkedlist

class SwapPairsLL(val list: MyLinkedList<Int>) {
    fun swap() : MyLinkedList.Node<Int>? {
        if (list.getHeadNode() == null) return null

        val dummyNode = MyLinkedList.Node<Int>(0)
        dummyNode.next = list.getHeadNode()

        var prevNode = dummyNode
        var currNode = dummyNode.next

        // P C N --> P N C
        while (currNode != null && currNode.next != null) {
            val nextNode = currNode.next

            currNode.next = nextNode?.next
            nextNode?.next = currNode
            prevNode.next = nextNode

            prevNode = currNode
            currNode = currNode.next
        }

        return dummyNode.next
    }
}