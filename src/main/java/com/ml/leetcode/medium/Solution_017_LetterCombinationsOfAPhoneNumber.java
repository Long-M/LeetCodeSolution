package com.ml.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mr.ml
 * @date 2021/6/29
 *
 * 给定一个仅包含数字2-9的字符串，返回所有它能表示的字母组合。答案可以按任意顺序返回。
 * 给出数字到字母的映射如下（与电话按键相同）。注意1不对应任何字母。
 */
public class Solution_017_LetterCombinationsOfAPhoneNumber {

    private String letterMap[] = {
            " ",    // 0
            "",     // 1
            "abc",  // 2
            "def",  // 3
            "ghi",  // 4
            "jkl",  // 5
            "mno",  // 6
            "pqrs", // 7
            "tuv",  // 8
            "wxyz"  // 9
    };

    private List<String> res = new ArrayList<>();;

    public List<String> letterCombinations(String digits) {
        if (digits.equals("")) {
            return res;
        }
        findCombination(digits, 0, "");
        return res;
    }

    public void findCombination(String digits, int index, String path) {
        // 当前位置下标等于length
        if (index == digits.length()) {
            res.add(path);
            return;
        }
        // 获取当前位置的数字
        Character c = digits.charAt(index);
        // 获取该数字对应的字符串
        String letters = letterMap[c - '0'];
        // 遍历字符串，搜索每种情况
        for (int i = 0; i < letters.length(); i++) {
            findCombination(digits, index + 1, path + letters.charAt(i));
        }
    }

}
