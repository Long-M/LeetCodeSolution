package com.ml.leetcode.medium;

/**
 * @author Mr.ml
 * @date 2021/7/12
 *
 * 给定一个非负整数数组nums，你最初位于数组的第一个下标。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个下标。
 */
public class Solution_055_JumpGame {

    public boolean canJump(int[] nums) {
        int canJumpIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > canJumpIndex) {
                return false;
            }
            canJumpIndex = Math.max(canJumpIndex, i + nums[i]);
        }
        return true;
    }

}
