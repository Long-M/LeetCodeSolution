package com.ml.leetcode.easy;

/**
 * @author Mr.ml
 * @date 2021/6/23
 *
 * 给你两个有序整数数组nums1和nums2，请你将nums2合并到nums1中，使nums1成为一个有序数组。
 * 初始化nums1和nums2的元素数量分别为m和n。你可以假设nums1的空间大小等于m+n，
 * 这样它就有足够的空间保存来自nums2的元素。
 */
public class Solution_088_MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, k = m + n - 1;
        while (i >= 0 && j >= 0) {
            nums1[k--] = nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];
        }
        // 将num2从下标0到j+1的元素拷贝到num1中
        System.arraycopy(nums2, 0, nums1, 0, j + 1);
    }

}
