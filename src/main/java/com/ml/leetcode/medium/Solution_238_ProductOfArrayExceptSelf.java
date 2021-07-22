package com.ml.leetcode.medium;

/**
 * @author Mr.ml
 * @date 2021/7/22
 *
 * 给你一个长度为n的整数数组nums，其中n>1，返回输出数组output，
 * 其中output[i]等于nums中除nums[i]之外其余各元素的乘积。
 */
public class Solution_238_ProductOfArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        // 用answer[i]表示下标为i的元素左边的元素乘积
        int[] answer = new int[length];
        answer[0] = 1;
        for (int i = 1; i < length; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }
        // 用R表示下标为i的元素右边的元素乘积
        int R = 1;
        for (int i = length - 1; i >= 0; i--) {
            answer[i] = answer[i] * R;
            R *= nums[i];
        }
        return answer;
    }

}
