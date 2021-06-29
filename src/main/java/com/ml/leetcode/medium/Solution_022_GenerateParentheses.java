package com.ml.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mr.ml
 * @date 2021/6/29
 *
 * 数字n代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且有效的括号组合。
 */
public class Solution_022_GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        // 执行深度优先遍历，搜索可能的结果
        dfs("", n, n, res);
        return res;
    }

    public void dfs(String curStr, int open, int close, List<String> res) {
        // 因为每一次尝试，都使用新的字符串变量，所以无需回溯
        // 在递归终止的时候，直接把它添加到结果集即可
        if (open == 0 && close == 0) {
            res.add(curStr);
            return;
        }

        // 剪枝
        if (open > close) {
            return;
        }

        if (open > 0) {
            dfs(curStr + "(", open - 1, close, res);
        }
        if (close > 0) {
            dfs(curStr + ")", open, close - 1, res);
        }
    }

    /**
     * 这里如果是严格按照「回溯法」的定义去做，是这样写的。大家可以比对一下，与直接使用字符串拼接在实现细节上的不同。
     * 在强调一下重点：「回溯算法」强调了在状态空间特别大的时候，只用一份状态变量去搜索所有可能的状态，
     * 在搜索到符合条件的解的时候，通常会做一个拷贝，这就是为什么经常在递归终止条件的时候，有res.add(new ArrayList<>(path));这样的代码。
     * 正是因为全程使用一份状态变量，因此它就有「恢复现场」和「撤销选择」的需要。
     *
     * @param curStr
     * @param open
     * @param close
     * @param res
     */
    public void backtrace(StringBuilder curStr, int open, int close, List<String> res) {
        if (open == 0 && close == 0) {
            res.add(curStr.toString());
            return;
        }

        // 剪枝
        if (open > close) {
            return;
        }

        if (open > 0) {
            curStr = curStr.append("(");
            backtrace(curStr, open - 1, close, res);
            // 回溯
            curStr.deleteCharAt(curStr.length() - 1);
        }
        if (close > 0) {
            curStr = curStr.append(")");
            backtrace(curStr, open, close - 1, res);
            // 回溯
            curStr.deleteCharAt(curStr.length() - 1);
        }
    }

}
