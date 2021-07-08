package com.ml.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Mr.ml
 * @date 2021/7/8
 *
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 *
 * 注意：
 * 你可以假设树中没有重复的元素。
 */
public class Solution_105_ConstructBinaryTreeFromPreorderAndInorderTraversal {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>();
        // 缓存节点下标
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTreeHelper(preorder, 0, preorder.length - 1, 0, inorder.length - 1, map);
    }

    public TreeNode buildTreeHelper(int[] preorder, int preStart, int preEnd, int inStart, int inEnd, Map<Integer, Integer> map) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        // 前序遍历的第一个节点就是根节点
        int rootVal = preorder[preStart];
        // 创建根节点对象
        TreeNode root = new TreeNode(rootVal);
        // 从缓存中获取根节点下标
        int index = map.get(rootVal);
        // 递归构造左子树
        root.left = buildTreeHelper(preorder, preStart + 1, preStart + index - inStart, inStart, index - 1, map);
        // 递归构造右子树
        root.right = buildTreeHelper(preorder, preStart + index - inStart + 1, preEnd, index + 1, inEnd, map);
        return root;
    }

}
