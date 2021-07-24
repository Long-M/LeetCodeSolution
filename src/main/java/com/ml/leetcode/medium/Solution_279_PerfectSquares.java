package com.ml.leetcode.medium;

/**
 * @author Mr.ml
 * @date 2021/7/24
 *
 * 给定正整数n，找到若干个完全平方数（比如1,4,9,16,...）使得它们的和等于n。你需要让组成和的完全平方数的个数最少。
 * 给你一个整数n，返回和为n的完全平方数的最少数量。
 * 完全平方数是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。
 * 例如，1、4、9和16都是完全平方数，而3和11不是。
 */
public class Solution_279_PerfectSquares {

    public int numSquares(int n) {
        // 默认初始化值都为0
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            // 最坏的情况就是每次+1
            dp[i] = i;
            for (int j = 1; j <= Math.sqrt(i); j++) {
                // 状态转移方程
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }

}
