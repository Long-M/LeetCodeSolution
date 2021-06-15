package com.ml.leetcode.easy;

/**
 * @author Mr.ml
 * @date 2021/6/15
 *
 * 给你单链表的头节点head，请你反转链表，并返回反转后的链表。
 */
public class Solution_206_ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null, cur = head, next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

}
