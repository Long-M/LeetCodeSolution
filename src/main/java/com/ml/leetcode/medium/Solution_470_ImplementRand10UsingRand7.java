package com.ml.leetcode.medium;

/**
 * @author Mr.ml
 * @date 2021/7/20
 *
 * 已有方法rand7可生成1到7范围内的均匀随机整数，试写一个方法rand10生成1到10范围内的均匀随机整数。
 * 不要使用系统的Math.random()方法。
 */
/**
 * The rand7() API is already defined in the parent class SolBase.
 * public int rand7();
 * @return a random integer in the range 1 to 7
 */
public class Solution_470_ImplementRand10UsingRand7 {

    public int rand10() {
        int row, column, idx;
        do {
            row = rand7();
            column = rand7();
            idx = (row - 1) * 7 + column;
        } while (idx > 40);
        return (idx - 1) % 10 + 1;
    }

    private int rand7() {
        return 0;
    }

}
