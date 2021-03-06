package com.ml.leetcode.medium;

/**
 * @author Mr.ml
 * @date 2021/7/26
 *
 * 在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。
 * 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。
 * 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
 * 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
 */
public class Solution_337_HouseRobberIII {

    public int rob(TreeNode root) {
        int[] rootStatus = dfs(root);
        // rootStatus[0]表示选择根节点，rootStatus[1]表示不选根节点
        return Math.max(rootStatus[0], rootStatus[1]);
    }

    public int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[2];
        }
        int[] l = dfs(root.left);
        int[] r = dfs(root.right);
        // 如果选中当前节点，则左子树和右子树的根节点都不能选择
        int selected = root.val + l[1] + r[1];
        // 如果没有选中当前节点，则可以选择左子树和右子树的根节点，选取最大值
        int notSelected = Math.max(l[0], l[1]) + Math.max(r[0], r[1]);
        return new int[]{selected, notSelected};
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
