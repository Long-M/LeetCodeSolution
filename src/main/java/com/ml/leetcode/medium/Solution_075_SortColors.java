package com.ml.leetcode.medium;

/**
 * @author Mr.ml
 * @date 2021/7/12
 *
 * 给定一个包含红色、白色和蓝色，一共n个元素的数组，原地对它们进行排序，
 * 使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 此题中，我们使用整数0、1和2分别表示红色、白色和蓝色。
 */
public class Solution_075_SortColors {

    public void sortColors(int[] nums) {
        int p0 = 0, p2 = nums.length - 1, cur = 0;
        while (cur <= p2) {
            if (nums[cur] == 0) {
                swap(nums, p0, cur);
                p0++;
                cur++;
            } else if (nums[cur] == 2) {
                swap(nums, p2, cur);
                p2--;
            } else {
                cur++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
