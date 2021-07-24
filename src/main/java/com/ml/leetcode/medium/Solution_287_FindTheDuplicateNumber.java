package com.ml.leetcode.medium;

/**
 * @author Mr.ml
 * @date 2021/7/24
 *
 * 给定一个包含n+1个整数的数组nums，其数字都在1到n之间（包括1和n），可知至少存在一个重复的整数。
 * 假设nums只有一个重复的整数，找出这个重复的数。
 * 你设计的解决方案必须不修改数组nums且只用常量级O(1)的额外空间。
 */
public class Solution_287_FindTheDuplicateNumber {

    public int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

}
