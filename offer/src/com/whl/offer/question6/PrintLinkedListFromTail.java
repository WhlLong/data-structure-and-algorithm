package com.whl.offer.question6;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 从尾到头打印链表
 * 题目描述
 * 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 */
public class PrintLinkedListFromTail {

    public static void main(String[] args) {
        SingleNode singleNode1 = getLinkedList();
        ArrayList<SingleNode> singleNodes = print1(singleNode1);
        for (SingleNode node : singleNodes) {
            System.out.println(node.key + " " + node.val);
        }

        System.out.println("=========1-2=============");

        SingleNode singleNode2 = getLinkedList();
        ArrayList<SingleNode> singleNodes2 = new ArrayList<>();
        print2(singleNode2, singleNodes2);
        for (SingleNode node : singleNodes2) {
            System.out.println(node.key + " " + node.val);
        }

        System.out.println("==========2-3============");

        SingleNode singleNode3 = getLinkedList();
        ArrayList<SingleNode> singleNodes3 = print3(singleNode3);
        for (SingleNode node : singleNodes3) {
            System.out.println(node.key + " " + node.val);
        }

        System.out.println("==========3-4============");

        SingleNode singleNode4 = getLinkedList();
        ArrayList<SingleNode> singleNodes4 = print4(singleNode4);
        for (SingleNode node : singleNodes4) {
            System.out.println(node.key + " " + node.val);
        }
    }

    private static SingleNode getLinkedList() {
        SingleNode node1 = new SingleNode("key1", "val1");
        SingleNode node2 = new SingleNode("key2", "val2");
        SingleNode node3 = new SingleNode("key3", "val3");
        SingleNode node4 = new SingleNode("key4", "val4");

        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);

        return node1;
    }

    /**
     * 使用栈来处理
     *
     * @param node
     * @return
     */
    public static ArrayList<SingleNode> print1(SingleNode node) {
        if (node == null) {
            return new ArrayList();
        }

        Stack<SingleNode> singleNodeStack = new Stack();
        singleNodeStack.push(node);
        while (node.getNext() != null) {
            singleNodeStack.push(node.getNext());
            node = node.next;
        }

        ArrayList<SingleNode> list = new ArrayList<>(singleNodeStack.size());
        while (!singleNodeStack.empty()) {
            list.add(singleNodeStack.pop());
        }

        return list;
    }


    /**
     * 递归处理
     *
     * @param node
     * @param list
     */
    public static void print2(SingleNode node, ArrayList<SingleNode> list) {

        if (node == null) {
            return;
        }

        if (node.next != null) {
            print2(node.next, list);
        }
        list.add(node);
    }


    /**
     * 翻转链表
     *
     * @param node
     */
    public static ArrayList<SingleNode> print3(SingleNode node) {
        reverseList(node);

        ArrayList<SingleNode> arrayList = new ArrayList<>();
        while (head != null) {
            arrayList.add(head);
            head = head.next;
        }

        return arrayList;
    }

    private static SingleNode head;
    private static SingleNode reverseList(SingleNode node) {
        if (node.next == null) {
            head = node;
            return node;
        }
        SingleNode preNode = reverseList(node.next);
        preNode.next = node;
        node.next = null;

        return node;
    }


    /**
     * 翻转链表,yuandi
     *
     * @param node
     */
    public static ArrayList<SingleNode> print4(SingleNode node) {

        SingleNode head = null;
        SingleNode pre = null;
        SingleNode next = null;

        while (node != null){
            head = node;
            next = node.next;
            node.next = pre;

            pre = node;
            node = next;
        }

        ArrayList<SingleNode> arrayList = new ArrayList<>();
        while(head != null){
            arrayList.add(head);
            head = head.next;
        }

        return arrayList;
    }
}
