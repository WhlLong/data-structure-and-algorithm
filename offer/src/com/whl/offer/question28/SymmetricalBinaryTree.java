package com.whl.offer.question28;

import com.whl.offer.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 对称二叉树
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。
 * 如果一棵二叉树和它的镜像一样，那么它是对称的。
 * <p>
 * 思路: 比较二叉树和它的镜像的前中后序遍历结果
 */
public class SymmetricalBinaryTree {

    public boolean isSymmetrical(TreeNode pRoot) {
        //前序遍历
        List<Integer> treePreList = new ArrayList<>();
        pre(pRoot, treePreList);
        //得到镜像
        Mirror(pRoot);
        //镜像前序遍历
        List<Integer> mirrorTreePreList = new ArrayList<>();
        pre(pRoot, mirrorTreePreList);
        //比较
        if (treePreList.size() != mirrorTreePreList.size()) {
            return false;
        }
        for (int i = 0; i < treePreList.size(); i++) {
            if (treePreList.get(i).compareTo(mirrorTreePreList.get(i)) != 0) {
                return false;
            }
        }

        return true;
    }

    private void pre(TreeNode pRoot, List<Integer> list) {
        if (pRoot == null) {
            return;
        }
        pre(pRoot.left, list);
        list.add(pRoot.val);
        pre(pRoot.right, list);
    }


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
