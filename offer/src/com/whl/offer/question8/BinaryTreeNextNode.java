package com.whl.offer.question8;

/**
 * 二叉树的下一个节点
 * 题目：
 * 给定一棵二叉树和其中一个节点，如何找出中序遍历序列的下一个节点？
 * 树中的节点除了有两个分别指向左右子节点的指针，还有一个指向父节点的指针。
 */
public class BinaryTreeNextNode {

    public static void main(String[] args) {
        
    }

    public TreeNode solution(TreeNode node) {
        if (node == null) {
            return null;
        }

        //1.如果当前节点没有父节点
        if (node.parent == null) {
            //1.1.如果该节点没有右子节点，那么就不存在下一个子节点。
            if (node.right == null) {
                return null;
            } else {
                //1.2.如果该节点有右子节点，那么下一个节点就是它的右子树的中序遍历的第一个节点。
                node = node.right;
                while (node.left != null) {
                    node = node.left;
                }
                return node;
            }
        } else {
            // 2.1.如果该节点是父节点的左子节点，那么下一个节点就是父节点。
            if (node == node.parent.left) {
                return node.parent;
            } else {
                //  2.2.如果该节点是父节点的右子节点:
                //2.2.1.如果它有右子节点，下一个节点就是它的右子树的中序遍历的第一个节点。
                if (node.right != null) {
                    node = node.right;
                    while (node.left != null) {
                        node = node.left;
                    }
                    return node;
                } else {
                    //2.2.2.如果它没有右子节点，下一个节点就要考虑父节点，以它的父节点为当前节点，然后从 2.2.3开始执行。
                    node = node.parent;
                    //2.2.3.如果当前节点为空，则不存在下一个节点。
                    while (node != null) {
                        // 2.3.4如果当前节点的父节点为空，则不存在下一个节点。
                        if (node.parent == null) {
                            return null;
                        } else {
                            //2.2.5.如果当前节点是父节点的右子节点，以当前节点的父节点作为当前节点，然后从 2.2.3开始执行。
                            if (node == node.parent.right) {
                                node = node.parent;
                            } else {
                                //2.2.6.如果当前节点是父节点的左子节点，那么下一个节点就是当前节点的父节点。
                                return node.parent;
                            }

                        }
                    }
                    return null;
                }
            }
        }
    }
}
