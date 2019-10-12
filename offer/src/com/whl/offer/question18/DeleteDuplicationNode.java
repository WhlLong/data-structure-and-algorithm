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
 *  情况一: 出现重复节点，保留一个
 *  情况二: 出现重复节点，一个不留，全部删除
 *
 */
public class DeleteDuplicationNode {

    /**
     * 情况一： 出现重复节点时，保留其中一个重复节点
     * @param pHead
     * @return
     */
    public ListNode deleteDuplication1(ListNode pHead) {

        if (pHead == null) {
            return null;
        }

        /**
         * 1.如果链表中只有一个节点，那么该链表中没有重复节点
         */
        if (pHead.next == null) {
            return pHead;
        }
        /**
         * 2.如果该链表中有多个节点。
         * 将链表的节点与它的后一个节点比较，如果相同就删除当前节点
         */


        return null;
    }



    public static void main(String[] args) {
        DeleteDuplicationNode deleteDuplicationNode = new DeleteDuplicationNode();

        ListNode listNode0 = new ListNode(1);
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(1);
        ListNode listNode3 = new ListNode(1);
        ListNode listNode4 = new ListNode(1);
        ListNode listNode5 = new ListNode(1);
        ListNode listNode6 = new ListNode(2);

        listNode5.next = listNode6;
        listNode4.next = listNode5;
        listNode3.next = listNode4;
        listNode2.next = listNode3;
        listNode1.next = listNode2;
        listNode0.next = listNode1;


        deleteDuplicationNode.deleteDuplication1(listNode0);


    }

}
