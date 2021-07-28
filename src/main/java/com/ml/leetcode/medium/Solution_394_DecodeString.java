package com.ml.leetcode.medium;

/**
 * @author Mr.ml
 * @date 2021/7/27
 *
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 * 编码规则为:k[encoded_string]，表示其中方括号内部的encoded_string正好重复k次。注意k保证为正整数。
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数k，例如不会出现像3a或2[4]的输入。
 */
public class Solution_394_DecodeString {

    public String decodeString(String s) {
        return dfs(s, 0)[0];
    }

    private String[] dfs(String s, int i) {
        StringBuilder res = new StringBuilder();
        int multi = 0;
        while (i < s.length()) {
            // 如果是数字
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                // 计算出数字完整的值
                multi = multi * 10 + Integer.parseInt(String.valueOf(s.charAt(i)));
            } else if (s.charAt(i) == '[') {
                String[] tmp = dfs(s, i + 1);
                // 获取当值为']'时，对应元素的下标，并赋值给i
                i = Integer.parseInt(tmp[0]);
                // 将multi个字符串添加到结果中
                while (multi > 0) {
                    res.append(tmp[1]);
                    multi--;
                }
            } else if (s.charAt(i) == ']') {
                return new String[]{String.valueOf(i), res.toString()};
            } else {
                res.append(String.valueOf(s.charAt(i)));
            }
            i++;
        }
        return new String[]{res.toString()};
    }

}
