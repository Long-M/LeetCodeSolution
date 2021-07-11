package com.ml.leetcode.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author Mr.ml
 * @date 2021/7/11
 *
 * 给定一个只包括'('，')'，'{'，'}'，'['，']'的字符串s，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 */
public class Solution_020_ValidParentheses {

    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        // 缓存括号的对应规则
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            // 如果是左括号
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                // 入栈
                stack.push(s.charAt(i));
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                Character top = stack.pop();
                // 判断该右括号是否与栈顶括号对应
                if (s.charAt(i) != map.get(top)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

}
