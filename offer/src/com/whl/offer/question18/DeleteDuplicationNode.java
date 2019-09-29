package com.whl.offer.question18;

/**
 * 删除链表中的重复节点
 * 题目：
 * 在一个排序的链表中，删除重复的节点
 * 例如下面的链表
 * 1 -> 2 -> 3 -> 3 -> 5
 * 在删除重复节点以后
 * 1 -> 2 -> 5
 */
public class DeleteDuplicationNode {

    public Node deleteDuplication(Node pHead) {
        Node head = null;
        while (pHead.next != null) {
            if (pHead.value == pHead.next.value) {


            }
        }

        return head;
    }

}
