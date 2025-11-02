package com.palak.linkedlist

class PartitionListLL<T>(val list: MyLinkedList<Int>)  {
    fun partitionList(k: Int) {
        if (list.getHeadNode() == null || list.getHeadNode()?.next == null) return
        val dummyBefore = MyLinkedList.Node(-1)
        val dummyAfter = MyLinkedList.Node(-1)
        var before = dummyBefore
        var after = dummyAfter
        var curr = list.getHeadNode()
        while (curr != null) {
            if (curr.value < k) {
                before.next = curr
                before = curr
            } else {
                after.next = curr
                after = curr
            }
            curr = curr.next
        }
        before.next = dummyAfter.next
        after.next = null
        // head = dummyBefore.next // Update head.
    }
}