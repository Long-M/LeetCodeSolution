package com.ml.leetcode.easy;

/**
 * @author Mr.ml
 * @date 2021/6/21
 *
 * 给定一个整数数组nums，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 */
public class Solution_053_MaximumSubarray {

    public int maxSubArray(int[] nums) {
        int ans = nums[0];
        // 当前的连续子数组最大和
        int pre = 0;
        for (int num : nums) {
            // 状态转移方程
            pre = Math.max(pre + num, num);
            // 更新最大ans
            ans = Math.max(ans, pre);
        }
        return ans;
    }

}
