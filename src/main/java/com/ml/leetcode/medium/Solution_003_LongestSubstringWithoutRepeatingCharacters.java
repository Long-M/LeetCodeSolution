package com.ml.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Mr.ml
 * @date 2021/6/17
 *
 * 给定一个字符串，请你找出其中不含有重复字符的最长子串的长度。
 */
public class Solution_003_LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        int ans = 0;
        for (int left = 0, right = 0; right < s.length(); right++) {
            if (map.containsKey(s.charAt(right))) {
                left = Math.max(left, map.get(s.charAt(right)) + 1);
            }
            map.put(s.charAt(right), right);
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }

}
