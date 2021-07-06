package com.ml.leetcode.medium;

import java.util.*;

/**
 * @author Mr.ml
 * @date 2021/7/6
 *
 * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 */
public class Solution_199_BinaryTreeRightSideView {

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Map<Integer, Integer> map = new HashMap<>();
        int maxDepth = 0;
        // 存储节点的栈
        Stack<TreeNode> nodeStack = new Stack<>();
        // 存储层级的栈
        Stack<Integer> depthStack = new Stack<>();
        nodeStack.push(root);
        depthStack.push(0);
        while (!nodeStack.isEmpty()) {
            TreeNode node = nodeStack.pop();
            int depth = depthStack.pop();
            if (node != null) {
                maxDepth = Math.max(maxDepth, depth);
                // 如果当前map中没有存储当前层级对应的节点
                if (!map.containsKey(depth)) {
                    map.put(depth, node.val);
                }
                nodeStack.push(node.left);
                nodeStack.push(node.right);
                depthStack.push(depth + 1);
                depthStack.push(depth + 1);
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i <= maxDepth; i++) {
            res.add(map.get(i));
        }
        return res;
    }

}
