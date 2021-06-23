package com.ml.leetcode.easy;

/**
 * @author Mr.ml
 * @date 2021/6/23
 *
 * 给定两个字符串形式的非负整数num1和num2，计算它们的和。
 * 提示：
 * num1和num2的长度都小于5100
 * num1和num2都只包含数字0-9
 * num1和num2都不包含任何前导零
 * 你不能使用任何內建BigInteger库，也不能直接将输入的字符串转换为整数形式
 */
public class Solution_415_AddStrings {

    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1, j = num2.length() - 1, add = 0;
        StringBuilder ans = new StringBuilder();
        while (i >= 0 || j >= 0 || add != 0) {
            // 根据ASCII码，int = char - '0'
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            int result = x + y + add;
            ans.append(result % 10);
            add = result / 10;
            i--;
            j--;
        }
        // 计算完以后的答案需要翻转过来
        ans.reverse();
        return ans.toString();
    }

}
