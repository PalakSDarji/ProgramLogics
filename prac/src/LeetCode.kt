
class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

fun hasCycle(head: ListNode?): Boolean {
    var slow = head
    var fast = head

    while (fast!=null && fast.next!=null) {
        slow = slow?.next
        fast = fast.next?.next
        if (slow == fast) {
            return true
        }
    }
    return false
}

fun detectCycle(head: ListNode?): ListNode? {
    var slow = head
    var fast = head

    while (fast != null && fast.next != null) {
        slow = slow?.next
        fast = fast.next?.next
        if (slow == fast) {
            var ptr1 = head
            var ptr2 = slow
            while (ptr1 != ptr2) {
                ptr1 = ptr1?.next
                ptr2 = ptr2?.next
            }
            return ptr1
        }
    }
    return null
}
/*
fun deleteOnlyDuplicates(head: ListNode?): ListNode? {
    var currentNode = head
    var prevNode: ListNode? = null
    while (currentNode != null) {
        if (currentNode.`val` == prevNode?.`val`) {
            prevNode.next = currentNode.next
        }
        prevNode = currentNode
        currentNode = currentNode.next
    }
    return head
}*/

fun deleteAllDuplicates(head: ListNode?): ListNode? {
    val dummy = ListNode(0)
    dummy.next = head
    var prev: ListNode? = dummy
    var current = head

    while (current != null) {
        var hasDuplicate = false
        while (current?.next != null && current.`val` == current.next?.`val`) {
            hasDuplicate = true
            current = current.next
        }
        if (hasDuplicate) {
            prev?.next = current?.next
        } else {
            prev = prev?.next
        }
        current = current?.next
    }

    return dummy.next
}