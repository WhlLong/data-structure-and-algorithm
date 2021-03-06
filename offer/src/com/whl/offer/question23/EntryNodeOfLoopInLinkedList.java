package com.whl.offer.question23;

import com.whl.offer.ListNode;

/**
 * 链表中环的入口节点
 * 如果一个链表中包含环，如何找出环的入口节点？
 * <p>
 * 思路：
 * 1.判断是否有环
 * 首先要判断链表中是否有环，判断是否有环可以通过快慢指针来解决，
 * 创建p1 p2两个指针，都指向头结点并且同时出发，p1每次往后走一步，p2每次往后走两步。
 * 如果出发以后p2能再追上p1，说明链表是有环的。如果p2节点走到了尾节点，说明链表是没有环的。
 * <p>
 * 2.找环的入口节点
 * 2.1 得到环的长度
 * 如果有环的话，那么第一步找到的相遇的点一定在环内，拿到这个节点以后，继续往下走，
 * 走的同时进行计数，当节点再次到达该节点时，已经绕环一圈了，这个时候的计数N就是环的长度。
 * <p>
 * 2.2 找到环的入口节点
 * 拿到环的长度以后，我们使用两个指针p3 p4，p5先走N步以后p6开始走，
 * 这样当两个节点再次相遇时，相遇的点就是环的入口节点。
 */
public class EntryNodeOfLoopInLinkedList {

    /**
     * 判断是否有环，如果返回为null，说明没有环
     *
     * @param head
     * @return
     */
    private ListNode meetNode(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode p1 = head;
        ListNode p2 = head;

        //走一步
        p1 = p1.next;
        if (p1 == null) {
            return null;
        }
        //走两步
        p2 = p1.next;

        while (p1 != null && p2 != null) {
            if (p1 == p2) {
                return p1;
            }

            p1 = p1.next;
            p2 = p2.next;
            if (p1 == p2) {
                return p1;
            } else {
                p2 = p2.next;
            }
        }

        return null;
    }

    /**
     * 获取环的长度
     *
     * @param node
     * @return
     */
    private int getLoopLength(ListNode node) {
        int length = 1;
        ListNode meetnode = node;
        while (node.next != meetnode) {
            node = node.next;
            length++;
        }

        return length;
    }

    public ListNode entryNodeOfLoop(ListNode head) {
        if (head == null) {
            return null;
        }

        //判断是否有环
        ListNode meetNode = meetNode(head);
        if (meetNode != null) {
            //获取环的长度
            int length = getLoopLength(meetNode);

            ListNode p3 = head;
            ListNode p4 = head;
            //p4先走length步
            for (int i = 0; i < length; i++) {
                p4 = p4.next;
            }

            while (p3 != p4) {
                p3 = p3.next;
                p4 = p4.next;
            }
            return p3;
        }
        return null;
    }


}
