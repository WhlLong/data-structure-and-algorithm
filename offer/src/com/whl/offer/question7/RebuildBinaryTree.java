package com.whl.offer.question7;

import com.whl.offer.TreeNode;

/**
 * 根据前序遍历结果和中序遍历结果重建二叉树
 * <p>
 * 题目描述:
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */
public class RebuildBinaryTree {

    public static void main(String[] args) {
        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] in = {4, 7, 2, 1, 5, 3, 8, 6};

        TreeNode root = rebuildBinaryTree(pre, in);
        System.out.println(root);
    }

    private static TreeNode rebuildBinaryTree(int[] pre, int[] in) {
        if (pre == null || pre.length == 0 || in == null || in.length == 0) {
            return null;
        }

        return buildBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    private static TreeNode buildBinaryTree(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        TreeNode root = new TreeNode(pre[preStart]);
        for (int i = inStart; i <= inEnd; i++) {
            if (in[i] == pre[preStart]) {
                /**
                 * 对于前序遍历来说，一个节点的左子树和右子数一定是按照顺序排列在该节点的后面的，
                 * 比如节点A，它的左子树中有B,C,D三个节点，右子树有E,F两个节点，那么在前序遍历结果中的最基本排列应该是B,C,D跟在A后面，E,F跟在B,C,D后面，
                 * 大致类似于A,B,C,D,E,F这样。
                 *
                 * 对于中序遍历来说，它的遍历结果中的某一个节点的左边一定是它的左子树中的节点，它的右边一定是它的右子树中的节点。
                 *
                 * 所以从前序遍历结果中拿到根节点(整个二叉树的根节点或者是某一棵子树的根节点)，然后在中序遍历结果中找到这个节点，
                 * 这个根节点的左边一定是它的左子树中的节点，它的右边一定是它的右子树中的节点。
                 *
                 * 前序遍历结果的第一个节点一定是整个二叉树的根节点，在中序遍历结果中找到这个节点，
                 * 然后它左边的节点就是整个二叉树的左子树中的节点，它的右边的节点就是整个二叉树的右子树中的节点，
                 * 然后递归的处理每一棵子树，最终就能重建这棵二叉树。
                 *
                 * (i - inStart) 代表的意思是从中序遍历结果中找到目标根节点走过了多少步，经过了多少次循环
                 *  preStart+1 ~ preStart+(i-Start) 代表的范围就是目标根节点的左子树经过前序遍历后在前序遍历结果中的范围，
                 *  preStart+1就是左子树的根节点
                 *  preStart + (i - inStart) + 1 ~ preEnd 代表的范围就是目标根节点的右子树经过前序遍历后在前序遍历结果中的范围，
                 *  preStart + (i - inStart) + 1就是右子树的根节点
                 */
                root.left = buildBinaryTree(pre, preStart + 1, preStart + (i - inStart), in, inStart, i - 1);
                root.right = buildBinaryTree(pre, preStart + (i - inStart) + 1, preEnd, in, i + 1, inEnd);
                break;
            }

        }

        return root;
    }
}
