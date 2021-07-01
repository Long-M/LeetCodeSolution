package com.ml.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mr.ml
 * @date 2021/7/1
 *
 * 给你一个m行n列的矩阵matrix，请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 */
public class Solution_054_SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int up = 0, right = matrix[0].length - 1, down = matrix.length - 1, left = 0;
        while (true) {
            // 从左到右
            for (int i = left; i <= right; i++) {
                res.add(matrix[up][i]);
            }
            if (++up > down) {
                break;
            }
            // 从上到下
            for (int i = up; i <= down; i++) {
                res.add(matrix[i][right]);
            }
            if (--right < left) {
                break;
            }
            // 从右到左
            for (int i = right; i >= left; i--) {
                res.add(matrix[down][i]);
            }
            if (--down < up) {
                break;
            }
            // 从下到上
            for (int i = down; i >= up; i--) {
                res.add(matrix[i][left]);
            }
            if (++left > right) {
                break;
            }
        }
        return res;
    }

}
