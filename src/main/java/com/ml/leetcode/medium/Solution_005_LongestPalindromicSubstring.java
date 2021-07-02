package com.ml.leetcode.medium;

/**
 * @author Mr.ml
 * @date 2021/7/3
 *
 * 给你一个字符串s，找到s中最长的回文子串。
 */
public class Solution_005_LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }
        // 动态维护最长回文字串的左边界和右边界
        int left = 0, right = 0;
        for (int i = 0; i < s.length(); i++) {
            // 以当前元素为中心扩展
            int len1 = expandAroundCenter(s, i, i);
            // 以两个相邻元素中间为中心扩展
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > right - left) {
                left = i - (len - 1) / 2;
                right = i + len / 2;
            }
        }
        return s.substring(left, right + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R <= s.length() - 1) {
            if (s.charAt(L) != s.charAt(R)) {
                break;
            }
            L--;
            R++;
        }
        return R - L - 1;
    }

}
