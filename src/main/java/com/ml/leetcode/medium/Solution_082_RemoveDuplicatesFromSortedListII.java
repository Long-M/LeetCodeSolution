package com.ml.leetcode.medium;

/**
 * @author Mr.ml
 * @date 2021/7/15
 *
 * 存在一个按升序排列的链表，给你这个链表的头节点head，请你删除链表中所有存在数字重复情况的节点，只保留原始链表中没有重复出现的数字。
 * 返回同样按升序排列的结果链表。
 */
public class Solution_082_RemoveDuplicatesFromSortedListII {

    public ListNode deleteDuplicates(ListNode head) {
        // 定义一个虚节点
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p = dummy;
        while (p.next != null && p.next.next != null) {
            boolean flag = false;
            // 判断当前节点的下一个节点和下一个节点的下一个节点值是否相等
            while (p.next != null && p.next.next != null && p.next.val == p.next.next.val) {
                flag = true;
                p.next = p.next.next;
            }
            if (flag) {
                p.next = p.next.next;
            } else {
                p = p.next;
            }
        }
        return dummy.next;
    }

}
