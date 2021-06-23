package com.ml.leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Mr.ml
 * @date 2021/6/23
 *
 * 给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 */
public class Solution_103_BinaryTreeZigzagLevelOrderTraversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        // 标记该层遍历方向
        boolean flag = true;
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int currentLevel = queue.size();
            LinkedList<Integer> tmp = new LinkedList<>();
            for (int i = 0; i < currentLevel; i++) {
                TreeNode node = queue.poll();
                if (flag) {
                    // 从左到右遍历
                    tmp.addLast(node.val);
                } else {
                    // 从右到左遍历
                    tmp.addFirst(node.val);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            // 状态转换
            flag = !flag;
            ans.add(tmp);
        }
        return ans;
    }

}
