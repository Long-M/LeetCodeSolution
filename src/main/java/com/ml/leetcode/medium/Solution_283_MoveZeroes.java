package com.ml.leetcode.medium;

/**
 * @author Mr.ml
 * @date 2021/7/24
 *
 * 给定一个数组nums，编写一个函数将所有0移动到数组的末尾，同时保持非零元素的相对顺序。
 */
public class Solution_283_MoveZeroes {

    public void moveZeroes(int[] nums) {
        // 左指针指向当前已经处理好的序列的尾部
        int left = 0;
        // 右指针指向待处理序列的头部
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] != 0) {
                int tmp = nums[right];
                nums[right] = nums[left];
                nums[left++] = tmp;
            }
        }
    }

}
