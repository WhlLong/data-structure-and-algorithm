package com.whl.offer.question27;

import com.whl.offer.TreeNode;

/**
 * 二叉树的镜像
 * 请完成一个函数，输入一棵二叉树，该函数输出它的镜像
 *
 * 从根节点开始，先调换它的左右节点，然后再以左右节点作为根节点分别调换他们的左右子节点，
 * 使用递归的方式来处理。
 */
public class ImagesOfBinaryTree {


    public void Mirror(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;

        root.left = right;
        root.right = left;

        Mirror(left);
        Mirror(right);
    }


}
