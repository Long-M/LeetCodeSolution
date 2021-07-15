package com.ml.leetcode.medium;

/**
 * @author Mr.ml
 * @date 2021/7/15
 *
 * 给你一个整数数组nums，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 */
public class Solution_152_MaximumProductSubarray {

    public int maxProduct(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        // 记录当前最小值是为了当nums[i]为负数时，得到最大值
        int res = Integer.MIN_VALUE, curMax = 1, curMin = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                int tmp = curMax;
                curMax = curMin;
                curMin = tmp;
            }
            // 更新当前最大值
            curMax = Math.max(nums[i], curMax * nums[i]);
            // 更新当前最小值
            curMin = Math.min(nums[i], curMin * nums[i]);
            // 更新全局最大值
            res = Math.max(res, curMax);
        }
        return res;
    }

}
