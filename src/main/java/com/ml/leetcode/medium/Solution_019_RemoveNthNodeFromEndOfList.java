package com.ml.leetcode.medium;

/**
 * @author Mr.ml
 * @date 2021/7/7
 *
 * 给你一个链表，删除链表的倒数第n个结点，并且返回链表的头结点。
 * 进阶：你能尝试使用一趟扫描实现吗？
 */
public class Solution_019_RemoveNthNodeFromEndOfList {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = head, second = dummy;
        while (n > 0) {
            n--;
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }

}
