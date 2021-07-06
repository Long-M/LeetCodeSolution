package com.ml.leetcode.medium;

/**
 * @author Mr.ml
 * @date 2021/7/6
 *
 * 给你一个字符串s，逐个翻转字符串中的所有单词。
 * 单词是由非空格字符组成的字符串。s中使用至少一个空格将字符串中的单词分隔开。
 * 请你返回一个翻转s中单词顺序并用单个空格相连的字符串。
 * 说明：
 * 输入字符串s可以在前面、后面或者单词间包含多余的空格。
 * 翻转后单词间应当仅用一个空格分隔。
 * 翻转后的字符串中不应包含额外的空格。
 */
public class Solution_151_ReverseWordsInAString {

    public String reverseWords(String s) {
        s = s.trim();
        StringBuilder res = new StringBuilder();
        // 双指针负责确定字符串首尾位置
        int left = s.length() - 1, right = s.length() - 1;
        while (left >= 0) {
            while (left >= 0 && s.charAt(left) != ' ') {
                left--;
            }
            res.append(s.substring(left + 1, right + 1) + " ");
            // 过滤空格
            while (left >= 0 && s.charAt(left) == ' ') {
                left--;
            }
            // 记录字符串结尾的下标
            right = left;
        }
        return res.toString().trim();
    }

}
