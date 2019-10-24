package com.whl.offer.question25;

import com.whl.offer.ListNode;

/**
 * 合并两个排序的链表
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 */
public class MergeTwoSortedLinkedList {


    public ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null || list2 == null) {
            return list1 == null ? list2 : list1;
        }

        ListNode newHead = list1.val < list2.val ? list1 : list2;
        ListNode pre = list1.val < list2.val ? list1 : list2;

        if (list1.val < list2.val) {
            list1 = list1.next;
        } else {
            list2 = list2.next;
        }

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                pre.next = list1;
                pre = list1;
                list1 = list1.next;
            } else {
                pre.next = list2;
                pre = list2;
                list2 = list2.next;
            }

        }


        pre.next = list1 == null ? list2 : list1;

        return newHead;
    }

}
