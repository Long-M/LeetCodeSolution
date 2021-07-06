package com.ml.leetcode.easy;

/**
 * @author Mr.ml
 * @date 2021/7/6
 *
 * 实现int sqrt(int x)函数。
 * 计算并返回x的平方根，其中x是非负整数。
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 */
public class Solution_069_SqrtX {

    public int mySqrt(int x) {
        if (x == 1) {
            return x;
        }
        int left = 1, right = x / 2, ans = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            if ((long) mid * mid <= x) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

}
