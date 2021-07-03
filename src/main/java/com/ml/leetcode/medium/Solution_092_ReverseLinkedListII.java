package com.ml.leetcode.medium;

/**
 * @author Mr.ml
 * @date 2021/7/3
 *
 * 给你单链表的头指针head和两个整数left和right，其中left<=right。
 * 请你反转从位置left到位置right的链表节点，返回反转后的链表。
 */
public class Solution_092_ReverseLinkedListII {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode pre = null, cur = head;
        while (left > 1) {
            pre = cur;
            cur = cur.next;
            left--;
            right--;
        }
        // con表示反转区间的前一段链表的最后一个节点
        // tail表示反转区间反转后的尾节点
        ListNode con = pre, tail = cur, next = null;
        // 反转区间内的部分
        while (right > 0) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
            right--;
        }
        // 如果con为null，说明left为1，则反转区间前面无链表
        if (con == null) {
            head = pre;
        } else {
            con.next = pre;
        }
        tail.next = cur;
        return head;
    }

}
