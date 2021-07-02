package com.ml.leetcode.medium;

/**
 * @author Mr.ml
 * @date 2021/7/2
 *
 * 整数数组nums按升序排列，数组中的值互不相同。
 *
 * 在传递给函数之前，nums在预先未知的某个下标k（0 <= k < nums.length）上进行了旋转，使数组变为[nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标从0开始计数）。
 * 例如，[0,1,2,4,5,6,7]在下标3处经旋转后可能变为[4,5,6,7,0,1,2]。
 * 给你旋转后的数组nums和一个整数target，如果nums中存在这个目标值target，则返回它的下标，否则返回-1。
 */
public class Solution_033_SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1, mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            // 先根据nums[0]与target的关系判断目标值是在左半段还是右半段
            if (nums[0] <= target) {
                // 目标值在左半段时，若mid在右半段，则将mid索引的值改成inf
                if (nums[mid] < nums[0]) {
                    nums[mid] = Integer.MAX_VALUE;
                }
            } else {
                // 目标值在右半段时，若mid在左半段，则将mid索引的值改成-inf
                if (nums[mid] >= nums[0]) {
                    nums[mid] = Integer.MIN_VALUE;
                }
            }

            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

}
