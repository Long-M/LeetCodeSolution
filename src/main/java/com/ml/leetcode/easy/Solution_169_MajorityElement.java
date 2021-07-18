package com.ml.leetcode.easy;

/**
 * @author Mr.ml
 * @date 2021/7/18
 *
 * 给定一个大小为n的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于⌊n/2⌋的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 */
public class Solution_169_MajorityElement {

    public int majorityElement(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        // 选取nums[0]候选元素
        int candidate = nums[0];
        // 默认票数为1
        int count = 1;
        for (int i = 0; i < nums.length; i++) {
            // 如果当前元素等于候选元素
            if (candidate == nums[i]) {
                // 票数加1
                count++;
            } else if (--count == 0) {
                // 否则票数减1，如果票数为0，选取当前元素为候选元素
                candidate = nums[i];
                // 重置票数为1
                count = 1;
            }
        }
        return candidate;
    }

}
