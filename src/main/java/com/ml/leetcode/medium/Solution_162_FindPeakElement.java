package com.ml.leetcode.medium;

/**
 * @author Mr.ml
 * @date 2021/7/5
 *
 * 峰值元素是指其值大于左右相邻值的元素。
 * 给你一个输入数组nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回任何一个峰值所在位置即可。
 * 你可以假设nums[-1]=nums[n]=-∞。
 *
 * 首先要注意题目条件，在题目描述中出现了nums[-1]=nums[n]=-∞，
 * 这就代表着只要数组中存在一个元素比相邻元素大，那么沿着它一定可以找到一个峰值。
 *
 * emm，这道题是我面字节番茄小说没做出来的题，导致那次面试没通过，谨以此题，纪念我与字节擦肩而过的瞬间。
 */
public class Solution_162_FindPeakElement {

    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 沿着递增的方向找
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

}
