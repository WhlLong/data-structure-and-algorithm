package com.whl.offer.question18;

/**
 * 删除链表中的节点
 * 题目一：
 * 在O(1)时间内删除链表中的节点
 * 给定单向链表的头结点和指定节点，定义一个函数在O(1)时间内删除该节点
 * <p>
 * 思路：
 * 如果按照第一思路，那么肯定是遍历链表，然后进行删除操作，这样做虽然能够做到删除链表中的节点，但是时间复杂度是O(N).
 * 单链表中虽然拿不到前一个节点，但是却可以拿到后面的节点，将后一个节点的信息复制到指定节点中，然后删除后一个节点，
 * 这样也能达到删除指定节点的目的。
 */
public class DeleteNodeInLinkedList {

    public void DeleteNode(ListNode head, ListNode toBeDeleted) {
        if (head == null || toBeDeleted == null) {
            return;
        }

        ListNode next = toBeDeleted.next;
        /**
         * 如果链表中只有一个节点
         */
        if (head == toBeDeleted && next == null) {
            head = null;
            toBeDeleted = null;
        }else{

        }
    }

}


