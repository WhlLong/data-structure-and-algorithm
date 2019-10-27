package com.whl.offer.question8;

/**
 * 二叉树的下一个节点
 * 题目：
 * 给定一棵二叉树和其中一个节点，如何找出中序遍历序列的下一个节点？
 * 树中的节点除了有两个分别指向左右子节点的指针，还有一个指向父节点的指针。
 *
 *
 *
 */
public class BinaryTreeNextNode {

    public static void main(String[] args) {

    }



    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        TreeLinkNode node;
        if(pNode.right!=null) {
            node=pNode.right;
            while(node.left!=null) {
                node=node.left;
            }
            return node;
        }
        node=pNode;
        while(node.next!=null) {
            if(node.next.left==node)
                return node.next;
            node=node.next;
        }
        return null;
    }
}
