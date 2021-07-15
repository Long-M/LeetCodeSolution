package com.ml.leetcode.easy;

/**
 * @author Mr.ml
 * @date 2021/7/15
 *
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素 只出现一次 。
 * 返回同样按升序排列的结果链表。
 */
public class Solution_083_RemoveDuplicatesFromSortedList {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode p = head;
        // 要保证p.next不出现空指针，所以要先判断p!=null
        while (p != null && p.next != null) {
            // 因为可能三个或多个相同元素，所以用while
            while (p.next != null && p.val == p.next.val) {
                p.next = p.next.next;
            }
            p = p.next;
        }
        return head;
    }

}
