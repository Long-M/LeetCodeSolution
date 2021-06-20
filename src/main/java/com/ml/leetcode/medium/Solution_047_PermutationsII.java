package com.ml.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Mr.ml
 * @date 2021/6/21
 *
 * 给定一个可包含重复数字的序列nums，按任意顺序返回所有不重复的全排列。
 */
public class Solution_047_PermutationsII {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        // 辅助数组，值为true表示该下标上的值访问过，false表示未访问过
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        generate(nums, path, ans, visited);
        return ans;
    }

    public void generate(int[] nums, List<Integer> path, List<List<Integer>> ans, boolean[] visited) {
        // 当前排列的长度等于数组长度时
        if (path.size() == nums.length) {
            // 将当前排列加入到结果集合中
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            // 当前下标上的值和前一个位置上的值相等时，并且前一个位置上的值被访问过
            if (i > 0 && nums[i] == nums[i - 1] && visited[i - 1]) {
                continue;
            }
            // 选取当前值加入当前排列
            path.add(nums[i]);
            visited[i] = true;
            generate(nums, path, ans, visited);
            visited[i] = false;
            // 回溯
            path.remove(path.size() - 1);
        }
    }

}
