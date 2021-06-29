package com.ml.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Mr.ml
 * @date 2021/6/28
 *
 * 给定一个无重复元素的数组candidates和一个目标数target，找出candidates中所有可以使数字和为target的组合。
 * candidates中的数字可以无限制重复被选取。
 * 说明：
 * 所有数字（包括target）都是正整数。
 * 解集不能包含重复的组合。
 */
public class Solution_039_CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, 0, target, path, res);
        return res;
    }

    public void backtrack(int[] candidates, int begin, int target, List<Integer> path, List<List<Integer>> res) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        // i从begin开始，结合排序，保证当前位置前面的数据不会被访问
        for (int i = begin; i < candidates.length; i++) {
            if (target - candidates[i] < 0) {
                break;
            }
            path.add(candidates[i]);
            // 因为一个数字可以重复选取，所以从i开始
            backtrack(candidates, i, target - candidates[i], path, res);
            // 回溯
            path.remove(path.size() - 1);
        }
    }

}
