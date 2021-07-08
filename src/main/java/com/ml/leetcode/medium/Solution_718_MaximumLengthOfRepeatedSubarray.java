package com.ml.leetcode.medium;

/**
 * @author Mr.ml
 * @date 2021/7/8
 *
 * 给两个整数数组A和B，返回两个数组中公共的、长度最长的子数组的长度。
 */
public class Solution_718_MaximumLengthOfRepeatedSubarray {

    public int findLength(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length, ans = 0;
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = nums1[i - 1] == nums2[j - 1] ? dp[i - 1][j - 1] + 1 : 0;
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans;
    }

}
