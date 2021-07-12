package com.ml.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mr.ml
 * @date 2021/7/12
 *
 * 给你一个整数数组nums，数组中的元素互不相同。返回该数组所有可能的子集（幂集）。
 * 解集不能包含重复的子集。你可以按任意顺序返回解集。
 */
public class Solution_078_Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, 0, new ArrayList<>(), res);
        return res;
    }

    private void dfs(int[] nums, int i, List<Integer> path, List<List<Integer>> res) {
        if (i == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        // 选中当前元素
        path.add(nums[i]);
        // 当选中当前元素时，继续选择余下的元素
        dfs(nums, i + 1, path, res);
        // 撤销选择
        path.remove(path.size() - 1);
        // 当不选当前元素时，继续选择余下的元素
        dfs(nums, i + 1, path, res);
    }

}
