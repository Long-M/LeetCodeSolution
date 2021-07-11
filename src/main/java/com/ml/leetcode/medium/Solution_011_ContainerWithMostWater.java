package com.ml.leetcode.medium;

/**
 * @author Mr.ml
 * @date 2021/7/11
 *
 * 给你n个非负整数a1，a2，...，an，每个数代表坐标中的一个点(i,ai)。
 * 在坐标内画n条垂直线，垂直线i的两个端点分别为(i,ai)和(i,0)。找出其中的两条线，
 * 使得它们与x轴共同构成的容器可以容纳最多的水。
 * 说明：你不能倾斜容器。
 */
public class Solution_011_ContainerWithMostWater {

    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxArea = 0;
        while (left < right) {
            maxArea = Math.max(maxArea, Math.min(height[left], height[right]) * (right - left));
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }

}
