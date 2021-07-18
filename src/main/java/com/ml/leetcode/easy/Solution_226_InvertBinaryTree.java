package com.ml.leetcode.easy;

/**
 * @author Mr.ml
 * @date 2021/7/18
 *
 * 翻转一棵二叉树。
 */
public class Solution_226_InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

}
