package com.ml.leetcode.medium;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Mr.ml
 * @date 2021/7/14
 *
 * 给定一个非空字符串s和一个包含非空单词的列表wordDict，判定s是否可以被空格拆分为一个或多个在字典中出现的单词。
 * 说明：
 * 拆分时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 */
public class Solution_139_Submissions {

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                // 如果s[0...j-1]可以拆分为字典中单词并且s[j...i-1]在字典中存在
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    // 则表示s[0...i-1]可以拆分为字典中单词
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

}
