package com.ml.leetcode.easy;

/**
 * @author Mr.ml
 * @date 2021/7/13
 *
 * 给定一个二叉树，检查它是否是镜像对称的。
 */
public class Solution_101_SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        // 有一个为null，说明不对称
        if (p == null || q == null) {
            return false;
        }
        // 值不相等，说明不对称
        if (p.val != q.val) {
            return false;
        }
        return isSymmetric(p.left, q.right) && isSymmetric(p.right, q.left);
    }

}
