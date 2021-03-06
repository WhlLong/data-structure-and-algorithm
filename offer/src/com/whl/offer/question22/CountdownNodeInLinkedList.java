package com.whl.offer.question22;

import com.whl.offer.ListNode;

/**
 * 链表中的倒数第K个节点
 * 题目:
 * 输入一个链表，输出该链表中的倒数第K个节点。
 * 为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是第一个节点。
 * <p>
 * 思路: 本题可采用双指针来处理
 * 指针一和指针二同时指向头结点，然后指针1先走k-1个节点，然后k指针二开始和指针一同步走，
 * 指针一到达尾节点时，指针二指向的就是最后一个节点
 */
public class CountdownNodeInLinkedList {

    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null || k <= 0) {
            return null;
        }

        ListNode node1 = head;
        ListNode node2 = head;
        for (int i = 0; i < k - 1; i++) {
            if (node1.next == null) {
                return null;
            }
            node1 = node1.next;
        }

        while (node1.next != null && node2.next != null) {
            node1 = node1.next;
            node2 = node2.next;
        }

        return node2;
    }

}
