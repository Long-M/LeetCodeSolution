package com.ml.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mr.ml
 * @date 2021/6/30
 *
 * 给定两个整数n和k，返回1...n中所有可能的k个数的组合。
 */
public class Solution_077_Combinations {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(1, n, k, new ArrayList<>(), res);
        return res;
    }

    public void backtrack(int i, int n, int k, List<Integer> path, List<List<Integer>> res) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int j = i; j <= n - (k - path.size()) + 1; j++) {
            path.add(j);
            backtrack(j + 1, n, k, path, res);
            path.remove(path.size() - 1);
        }
    }

}
