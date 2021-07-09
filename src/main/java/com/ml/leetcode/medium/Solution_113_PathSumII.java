package com.ml.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mr.ml
 * @date 2021/7/9
 *
 * 给你二叉树的根节点root和一个整数目标和targetSum，找出所有从根节点到叶子节点路径总和等于给定目标和的路径。
 * 叶子节点是指没有子节点的节点。
 */
public class Solution_113_PathSumII {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(root, targetSum, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(TreeNode root, int targetSum, List<Integer> path, List<List<Integer>> res) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        if (root.left == null && root.right == null && targetSum == root.val) {
            res.add(new ArrayList<>(path));
        }
        backtrack(root.left, targetSum - root.val, path, res);
        backtrack(root.right, targetSum - root.val, path, res);
        path.remove(path.size() - 1);
    }

}
