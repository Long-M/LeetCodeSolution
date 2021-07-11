package com.ml.leetcode.medium;

/**
 * @author Mr.ml
 * @date 2021/7/11
 *
 * 给定一个n×n的二维矩阵matrix表示一个图像。请你将图像顺时针旋转90度。
 * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
 *
 * 找规律，两次交换，第一次以对角线为中心交换，第二次左右交换
 */
public class Solution_48_RotateImage {

    public void rotate(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = i; j < n; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = tmp;
            }
        }
    }

}
