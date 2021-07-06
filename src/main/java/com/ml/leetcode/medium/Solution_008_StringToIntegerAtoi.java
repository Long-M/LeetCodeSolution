package com.ml.leetcode.medium;

/**
 * @author Mr.ml
 * @date 2021/7/6
 *
 * 请你来实现一个myAtoi(string s)函数，使其能将字符串转换成一个32位有符号整数（类似C/C++中的atoi函数）。
 * 函数myAtoi(string s)的算法如下：
 * 读入字符串并丢弃无用的前导空格
 * 检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。确定最终结果是负数还是正数。如果两者都不存在，则假定结果为正。
 * 读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
 * 将前面步骤读入的这些数字转换为整数（即，"123"->123，"0032"->32）。如果没有读入数字，则整数为0。必要时更改符号（从步骤2开始）。
 * 如果整数数超过32位有符号整数范围[−2^31,2^31−1]，需要截断这个整数，使其保持在这个范围内。
 * 具体来说，小于−2^31的整数应该被固定为−2^31，大于2^31−1的整数应该被固定为2^31−1。
 * 返回整数作为最终结果。
 * 注意：
 * 本题中的空白字符只包括空格字符' '。
 * 除前导空格或数字后的其余字符串外，请勿忽略任何其他字符。
 */
public class Solution_008_StringToIntegerAtoi {

    public int myAtoi(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        // 去空格
        int index = 0;
        while (index < len && chars[index] == ' ') {
            index++;
        }
        // 排除极端情况 "    "
        if (index == len) {
            return 0;
        }
        // 设置符号
        int sign = 1;
        char firstChar = chars[index];
        if (firstChar == '-') {
            index++;
            sign = -1;
        } else if (firstChar == '+') {
            index++;
        }
        // last记录上一次的res，以此来判断是否溢出
        int res = 0, last = 0;
        while (index < len) {
            char currentChar = chars[index];
            if (currentChar < '0' || currentChar > '9') {
                break;
            }
            last = res;
            res = res * 10 + currentChar - '0';
            // 如果不相等就是溢出了
            if (last != res / 10) {
                return (sign == (-1)) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            index++;
        }
        return res * sign;
    }

}
