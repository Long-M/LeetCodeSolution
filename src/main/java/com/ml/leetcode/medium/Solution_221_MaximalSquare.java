package com.ml.leetcode.medium;

/**
 * @author Mr.ml
 * @date 2021/7/18
 *
 * 在一个由'0'和'1'组成的二维矩阵内，找到只包含'1'的最大正方形，并返回其面积。
 */
public class Solution_221_MaximalSquare {

    public int maximalSquare(char[][] matrix) {
        int maxSide = 0;
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return maxSide;
        }
        int rows = matrix.length, columns = matrix[0].length;
        // dp[i][j]表示当前位置正方形的最大边长
        int[][] dp = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                // 当前元素为1才能构成正方形
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    }
                }
                // 更新全局最大边长
                maxSide = Math.max(maxSide, dp[i][j]);
            }
        }
        return maxSide * maxSide;
    }

}
