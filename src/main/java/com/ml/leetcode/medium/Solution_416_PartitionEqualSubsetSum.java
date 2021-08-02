package com.ml.leetcode.medium;

/**
 * @author Mr.ml
 * @date 2021/8/2
 *
 * 给你一个只包含正整数的非空数组nums。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 */
public class Solution_416_PartitionEqualSubsetSum {

    public boolean canPartition(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return false;
        }
        int sum = 0, maxNum = 0;
        for (int num : nums) {
            sum += num;
            maxNum = Math.max(maxNum, num);
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        if (maxNum > target) {
            return false;
        }
        // dp[i][j]表示从数组的[0,i]下标范围内选取若干个正整数（可以是0个），是否存在一种选取方案使得被选取的正整数的和等于j
        boolean[][] dp = new boolean[n][target + 1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }
        dp[0][nums[0]] = true;
        for (int i = 1; i < n; i++) {
            int num = nums[i];
            for (int j = 1; j <= target; j++) {
                // 如果和大于num
                if (j >= num) {
                    // 则可以选num，也可以不选num
                    dp[i][j] = dp[i - 1][j] | dp[i - 1][j - num];
                } else {
                    // 不选num
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n - 1][target];
    }

}
