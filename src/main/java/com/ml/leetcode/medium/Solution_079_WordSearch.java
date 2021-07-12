package com.ml.leetcode.medium;

/**
 * @author Mr.ml
 * @date 2021/7/12
 *
 * 给定一个mxn二维字符网格board和一个字符串单词word。如果word存在于网格中，返回true；否则，返回false。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
 * 同一个单元格内的字母不允许被重复使用。
 */
public class Solution_079_WordSearch {

    public boolean exist(char[][] board, String word) {
        int n = board.length, m = board[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dfs(board, i, j, 0, word.toCharArray())) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int i, int j, int k, char[] word) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[i].length || word[k] != board[i][j]) {
            return false;
        }
        if (k == word.length - 1) {
            return true;
        }
        char tmp = board[i][j];
        // 表示该元素被访问过
        board[i][j] = '.';
        boolean res = dfs(board, i, j + 1, k + 1, word) || dfs(board, i + 1, j, k + 1, word) || dfs(board, i - 1, j, k + 1, word) || dfs(board, i, j - 1, k + 1, word);
        board[i][j] = tmp;
        return res;
    }

}
