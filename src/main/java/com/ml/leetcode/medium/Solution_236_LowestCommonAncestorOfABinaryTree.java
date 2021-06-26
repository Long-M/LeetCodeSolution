package com.ml.leetcode.medium;

/**
 * @author Mr.ml
 * @date 2021/6/26
 *
 * 给定一个二叉树，找到该树中两个指定节点的最近公共祖先。
 * 百度百科中最近公共祖先的定义为："对于有根树T的两个节点p、q，最近公共祖先表示为一个节点x，
 * 满足x是p、q的祖先且x的深度尽可能大（一个节点也可以是它自己的祖先）。”
 */
public class Solution_236_LowestCommonAncestorOfABinaryTree {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 递归退出条件，如果root为null或者root与其中一个节点重合
        if (root == null || root == p || root == q) {
            return root;
        }
        // 分而治之，先寻找左子树中是否有公共祖先
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        // 再寻找右子树中是否有公共祖先
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        // 如果左右子树中都没有公共祖先，那么root节点就是公共祖先
        return root;
    }

}
