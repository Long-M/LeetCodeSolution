package com.ml.leetcode.easy;

/**
 * @author Mr.ml
 * @date 2021/7/10
 *
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。
 * 这条路径可能穿过也可能不穿过根结点。
 */
public class Solution_543_DiameterOfBinaryTree {

    private int ans = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        getDepth(root);
        return ans;
    }

    private int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int L = getDepth(root.left);
        int R = getDepth(root.right);
        ans = Math.max(ans, L + R);
        return Math.max(L, R) + 1;
    }

}
