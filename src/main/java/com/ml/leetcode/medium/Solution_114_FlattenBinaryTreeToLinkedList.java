package com.ml.leetcode.medium;

/**
 * @author Mr.ml
 * @date 2021/7/13
 *
 * 给你二叉树的根结点root，请你将它展开为一个单链表：
 * 展开后的单链表应该同样使用TreeNode，其中right子指针指向链表中下一个结点，而左子指针始终为null。
 * 展开后的单链表应该与二叉树先序遍历顺序相同。
 */
public class Solution_114_FlattenBinaryTreeToLinkedList {

    public void flatten(TreeNode root) {
        TreeNode cur = root;
        while (cur != null) {
            if (cur.left != null) {
                TreeNode next = cur.left;
                TreeNode pre = next;
                while (pre.right != null) {
                    pre = pre.right;
                }
                pre.right = cur.right;
                cur.left = null;
                cur.right = next;
            }
            cur = cur.right;
        }
    }

}
