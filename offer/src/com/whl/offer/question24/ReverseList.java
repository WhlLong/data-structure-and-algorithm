package com.whl.offer.question24;

import com.whl.offer.DoublyLinkedListNode;
import com.whl.offer.ListNode;

/**
 * 反转链表
 * 定义一个函数，输入一个链表的头结点，反转该链表并输出反转后的头结点。
 * <p>
 * 链表反转可以使用双指针的方式来进行，一个指针保存前一个节点，另一个指针向后走
 */
public class ReverseList {

    public static void main(String[] args) {

        ReverseList reverseList = new ReverseList();

        DoublyLinkedListNode node1 = new DoublyLinkedListNode(1);
        DoublyLinkedListNode node2 = new DoublyLinkedListNode(2);
        DoublyLinkedListNode node3 = new DoublyLinkedListNode(3);
        DoublyLinkedListNode node4 = new DoublyLinkedListNode(4);
        DoublyLinkedListNode node5 = new DoublyLinkedListNode(5);

/*        node1.next = node2;
        node2.pre = node1;
        node2.next = node3;
        node3.pre = node2;
        node3.next = node4;
        node4.pre = node3;
        node4.next = node5;
        node5.pre = node4;*/

//        DoublyLinkedListNode head = reverseList.ReverseDoublyLinkedList(node1);


        node1.next = node2;
        node2.pre = node1;
        node2.next = node3;
        node3.pre = node2;
        node3.next = node4;
        node4.pre = node3;
        node4.next = node5;
        node5.pre = node4;
        node5.next = node1;

        node1.pre = node5;

        DoublyLinkedListNode head = reverseList.ReverseCircularLinkedList(node1);
        System.out.println(head);
    }


    /**
     * 单链表反转
     */
    public ListNode ReverseSingleLinkedList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode pre = null;
        ListNode next = null;

        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }

        return pre;
    }

    /**
     * 双向链表反转
     */
    public DoublyLinkedListNode ReverseDoublyLinkedList(DoublyLinkedListNode head) {
        if (head == null) {
            return null;
        }

        DoublyLinkedListNode pre = null;
        DoublyLinkedListNode next = null;

        while (head != null) {
            next = head.next;

            head.next = pre;
            head.pre = next;

            pre = head;
            head = next;
        }

        return pre;
    }

    /**
     * 循环链表反转
     */
    public DoublyLinkedListNode ReverseCircularLinkedList(DoublyLinkedListNode head) {
        if (head == null) {
            return null;
        }

        DoublyLinkedListNode pre = null;
        DoublyLinkedListNode next = null;

        DoublyLinkedListNode root = head;
        boolean waitStart = true;

        while (head != root || waitStart) {
            next = head.next;

            head.next = pre;
            head.pre = next;

            pre = head;
            head = next;

            waitStart = false;
        }

        return pre;
    }


}
