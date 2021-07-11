package com.ml.leetcode.medium;

/**
 * @author Mr.ml
 * @date 2021/7/11
 *
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * 必须原地修改，只允许使用额外常数空间。
 */
public class Solution_031_NextPermutation {

    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int firstIndex = -1;
        // 找到第一个比后一个元素小的元素
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                firstIndex = i;
                break;
            }
        }
        // 如果没找到比后一个元素小的元素，说明是最后一个排列
        if (firstIndex == -1) {
            // 反转整个排列
            reverse(nums, 0, nums.length - 1);
            return;
        }
        int secondIndex = -1;
        // 查找第一个比nums[firstIndex]大的元素
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] > nums[firstIndex]) {
                secondIndex = i;
                break;
            }
        }
        swap(nums, firstIndex, secondIndex);
        // 反转firstIndex后的元素
        reverse(nums, firstIndex + 1, nums.length - 1);
    }

    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i++, j--);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
