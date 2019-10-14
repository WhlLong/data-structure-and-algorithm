package com.whl.offer.question18;

/**
 * 删除链表中的重复节点
 * 题目：
 * 在一个排序的链表中，删除重复的节点
 * 例如下面的链表
 * 1 -> 2 -> 3 -> 3 -> 5
 * 在删除重复节点以后
 * 1 -> 2 -> 5
 * <p>
 * <p>
 * <p>
 * 情况一: 出现重复节点，保留一个
 * 情况二: 出现重复节点，一个不留，全部删除
 */
public class DeleteDuplicationNode {

    /**
     * 情况一： 出现重复节点时，保留其中一个重复节点
     * 思路； 从头结点开始，如果发现当前节点和下一个节点重复，就删除下一个节点。
     *
     * @param pHead
     * @return
     */
    public ListNode deleteDuplication1(ListNode pHead) {

        if (pHead == null) {
            return null;
        }

        ListNode head = pHead;
        boolean isDup = false;
        while (pHead.next != null) {
            if (pHead.val == pHead.next.val) {
                pHead.next = pHead.next.next;
                isDup = true;
            } else {
                isDup = false;
            }

            if (!isDup) {
                pHead = pHead.next;
            }
        }

        return head;
    }

    /**
     * 情况二: 出现重复节点，一个不留，删除全部重复节点
     *
     * @param pHead
     * @return
     */
    public ListNode deleteDuplication2(ListNode pHead) {
        if (pHead == null) {
            return null;
        }
        ListNode head = new ListNode(Integer.MIN_VALUE);
        head.next = pHead;
        ListNode pre = head;
        boolean isDup = false;
        while (pHead != null) {
            if (pHead.next != null && pHead.val == pHead.next.val) {
                while (pHead.next != null && pHead.val == pHead.next.val) {
                    pHead = pHead.next;
                }
                pre.next = pHead.next;
                pHead = pHead.next;
            } else {
                pre = pre.next;
                pHead = pHead.next;
            }
        }
        return head.next;
    }

    public static void main(String[] args) {
        DeleteDuplicationNode deleteDuplicationNode = new DeleteDuplicationNode();

        ListNode listNode0 = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(5);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode6 = new ListNode(7);

        listNode5.next = listNode6;
        listNode4.next = listNode5;
        listNode3.next = listNode4;
        listNode2.next = listNode3;
        listNode1.next = listNode2;
        listNode0.next = listNode1;


        ListNode head = deleteDuplicationNode.deleteDuplication2(listNode0);
        System.out.println(head);

    }

}
