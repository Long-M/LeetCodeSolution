package com.ml.leetcode.easy;

/**
 * @author Mr.ml
 * @date 2021/7/26
 *
 * 给定一个非负整数num。对于0≤i≤num范围中的每个数字i，计算其二进制数中的1的数目并将它们作为数组返回。
 */
public class Solution_338_CountingBits {

    public int[] countBits(int n) {
        int[] bits = new int[n + 1];
        int highBit = 0;
        for (int i = 1; i <= n; i++) {
            // 如果该数只有一位为1，则该数为2的整数次幂
            if ((i & (i - 1)) == 0) {
                // 更新当前的最高有效位
                highBit = i;
            }
            // 状态转移方程
            bits[i] = bits[i - highBit] + 1;
        }
        return bits;
    }

}
