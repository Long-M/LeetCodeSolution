package com.ml.leetcode.easy;

/**
 * @author Mr.ml
 * @date 2021/7/9
 *
 * 给你二叉树的根节点root和一个表示目标和的整数targetSum，判断该树中是否存在根节点到叶子节点的路径，
 * 这条路径上所有节点值相加等于目标和targetSum。
 * 叶子节点是指没有子节点的节点。
 */
public class Solution_112_PathSum {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }

}
