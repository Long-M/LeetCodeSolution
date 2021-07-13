package com.ml.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Mr.ml
 * @date 2021/7/13
 *
 * 给定一个未排序的整数数组nums，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * 进阶：你可以设计并实现时间复杂度为O(n)的解决方案吗？
 */
public class Solution_128_LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        // 全局最大值
        int longestStreak = 0;
        for (int num : nums) {
            // 如果set中不存在num-1，说明该元素与前面元素不连续
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;
                // 搜索从该元素开始连续序列的长度
                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }
                // 更新全局最大值
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }
        return longestStreak;
    }

}
