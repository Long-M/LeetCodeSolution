package com.ml.leetcode.medium;

/**
 * @author Mr.ml
 * @date 2021/7/10
 *
 * 给你两个非空的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，
 * 并且每个节点只能存储一位数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字0之外，这两个数都不会以0开头。
 */
public class Solution_002_AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        ListNode res = new ListNode(0);
        ListNode cur = res;
        int total = 0, carry = 0;
        while (l1 != null || l2 != null) {
            int num1 = l1 == null ? 0 : l1.val;
            int num2 = l2 == null ? 0 : l2.val;
            total = num1 + num2 + carry;
            ListNode node = new ListNode(total % 10);
            cur.next = node;
            cur = cur.next;
            // 进位
            carry = total / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        // 如果进位不为0
        if (carry != 0) {
            // 添加一个节点
            cur.next = new ListNode(carry);
        }
        return res.next;
    }

}
