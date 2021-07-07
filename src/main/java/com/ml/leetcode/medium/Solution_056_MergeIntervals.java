package com.ml.leetcode.medium;

import java.util.Arrays;

/**
 * @author Mr.ml
 * @date 2021/7/7
 *
 *
 */
public class Solution_056_MergeIntervals {

    public int[][] merge(int[][] intervals) {
        // 先按照区间起始位置排序
        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);
        // 结果数组
        int[][] res = new int[intervals.length][2];
        int idx = -1;
        for (int[] interval: intervals) {
            // 如果结果数组是空的，或者当前区间的起始位置大于结果数组中最后区间的终止位置
            if (idx == -1 || interval[0] > res[idx][1]) {
                // 则不合并，直接将当前区间加入结果数组
                res[++idx] = interval;
            } else {
                // 反之将当前区间合并至结果数组的最后区间
                res[idx][1] = Math.max(res[idx][1], interval[1]);
            }
        }
        return Arrays.copyOf(res, idx + 1);
    }

}
