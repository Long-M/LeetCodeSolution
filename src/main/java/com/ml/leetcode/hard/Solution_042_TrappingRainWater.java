package com.ml.leetcode.hard;

import java.util.Stack;

/**
 * @author Mr.ml
 * @date 2021/7/3
 *
 * 给定n个非负整数表示每个宽度为1的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 */
public class Solution_042_TrappingRainWater {

    public int trap(int[] height) {
        int sum = 0, maxLeft = 0;
        int[] maxRight = new int[height.length];
        for (int i = height.length - 2; i >= 0; i--) {
            // 它后边的墙的右边的最高高度和它后边的墙的高度选一个较大的，就是当前列右边最高的墙了
            maxRight[i] = Math.max(maxRight[i + 1], height[i + 1]);
        }
        for (int i = 1; i < height.length - 1; i++) {
            // 它前边的墙的左边的最高高度和它前边的墙的高度选一个较大的，就是当前列左边最高的墙了
            maxLeft = Math.max(maxLeft, height[i - 1]);
            int min = Math.min(maxLeft, maxRight[i]);
            // 较矮的墙比当前墙高
            if (min > height[i]) {
                // 可以接高度差个单位的雨水
                sum += min - height[i];
            }
        }
        return sum;
    }

    public int trap2(int[] height) {
        int sum = 0;
        Stack<Integer> stack = new Stack<>();
        int current = 0;
        while (current < height.length) {
            // 如果栈不空并且当前指向的高度大于栈顶高度就一直循环
            while (!stack.empty() && height[current] > height[stack.peek()]) {
                // 取出出栈的元素
                int h = height[stack.pop()];
                stack.pop();
                // 栈空就退出循环
                if (stack.empty()) {
                    break;
                }
                // 两堵墙之前的距离
                int distance = current - stack.peek() - 1;
                int min = Math.min(height[stack.peek()], height[current]);
                sum = sum + distance * (min - h);
            }
            // 当前指向的墙入栈
            stack.push(current);
            // 指针后移
            current++;
        }
        return sum;
    }

}
