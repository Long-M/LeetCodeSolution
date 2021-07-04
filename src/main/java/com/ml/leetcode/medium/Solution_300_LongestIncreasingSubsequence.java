package com.ml.leetcode.medium;

/**
 * @author Mr.ml
 * @date 2021/7/5
 *
 * 给你一个整数数组nums，找到其中最长严格递增子序列的长度。
 * 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。
 * 例如，[3,6,2,7]是数组[0,3,1,6,2,2,7]的子序列。
 */
public class Solution_300_LongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        // 全局最大值
        int ans = 0;
        for (int i = 0; i < n; i++) {
            // 默认初始化为1，表示nums[i]单独作为一个子序列
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    // 状态转移方程
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            // 更新全局最大值
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

}
