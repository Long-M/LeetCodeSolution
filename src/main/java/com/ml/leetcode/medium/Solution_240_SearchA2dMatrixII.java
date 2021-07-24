package com.ml.leetcode.medium;

/**
 * @author Mr.ml
 * @date 2021/7/24
 *
 * 编写一个高效的算法来搜索mxn矩阵matrix中的一个目标值target。该矩阵具有以下特性：
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 */
public class Solution_240_SearchA2dMatrixII {

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int i = 0, j = n - 1;
        while (i <= m - 1 && j >= 0) {
            if (target == matrix[i][j]) {
                return true;
            } else if (target > matrix[i][j]) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }

}
