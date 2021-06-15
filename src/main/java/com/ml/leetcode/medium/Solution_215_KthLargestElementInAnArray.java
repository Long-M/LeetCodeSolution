package com.ml.leetcode.medium;

/**
 * @author Mr.ml
 * @date 2021/6/15
 *
 * 在未排序的数组中找到第k个最大的元素。请注意，你需要找的是数组排序后的第k个最大的元素，
 * 而不是第k个不同的元素。
 */
public class Solution_215_KthLargestElementInAnArray {

    public int findKthLargest(int[] nums, int k) {
        int heapSize = nums.length;
        buildHeap(nums, heapSize);
        for (int i = nums.length - 1; i >= nums.length - k + 1; i--) {
            swap(nums, 0, i);
            heapSize--;
            heapify(nums, 0, heapSize);
        }
        return nums[0];
    }

    public void buildHeap(int[] nums, int heapSize) {
        for (int i = heapSize / 2; i >= 0; i--) {
            heapify(nums, i, heapSize);
        }
    }

    public void heapify(int[] nums, int i, int heapSize) {
        int left = 2 * i + 1, right = 2 * i + 2, largest = i;
        if (left < heapSize && nums[left] > nums[largest]) {
            largest = left;
        }
        if (right < heapSize && nums[right] > nums[largest]) {
            largest = right;
        }
        if (largest != i) {
            swap(nums, largest, i);
            heapify(nums, largest, heapSize);
        }
    }

    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

}
