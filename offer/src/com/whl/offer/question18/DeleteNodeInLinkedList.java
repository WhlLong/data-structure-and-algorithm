package com.whl.offer.question18;

import com.whl.offer.ListNode;

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


    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;


        
        DeleteNodeInLinkedList nodeInLinkedList = new DeleteNodeInLinkedList();
        nodeInLinkedList.DeleteNode(listNode1, listNode4);
        System.out.println(listNode1);


        nodeInLinkedList.DeleteNode(listNode1, listNode2);
        System.out.println(listNode1);
    }


    public void DeleteNode(ListNode head, ListNode toBeDeleted) {
        if (head == null || toBeDeleted == null) {
            return;
        }

        //只有一个节点
        if (head == toBeDeleted && toBeDeleted.next == null) {
            //java中的非基本类型传参，都是引用传递，所以当只有一个节点是，是无法处理这个问题的，
            // 除非该方法有返回值，返回新的头结点
            return;
        }

        //不止一个节点,当前节点是尾节点
        if (head != toBeDeleted && toBeDeleted.next == null) {
            while (head.next != null) {
                if (head.next == toBeDeleted) {
                    head.next = null;
                    return;
                }
                head = head.next;
            }
        }

        //不止一个节点，当前节点不是尾节点
        if (head != toBeDeleted && toBeDeleted.next != null) {
            toBeDeleted.val = toBeDeleted.next.val;
            toBeDeleted.next = toBeDeleted.next.next;
        }
    }

}


