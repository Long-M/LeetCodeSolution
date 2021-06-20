package com.ml.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mr.ml
 * @date 2021/6/20
 *
 * 给定一个不含重复数字的数组nums，返回其所有可能的全排列。你可以按任意顺序返回答案。
 */
public class Solution_046_Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        generate(nums, path, ans);
        return ans;
    }

    public void generate(int[] nums, List<Integer> path, List<List<Integer>> ans) {
        if (path.size() == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // 剪枝
            if (path.contains(nums[i])) {
                continue;
            }
            path.add(nums[i]);
            generate(nums, path, ans);
            path.remove(path.size() - 1);
        }
    }

}
