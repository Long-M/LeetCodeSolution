package com.ml.leetcode.medium;

/**
 * @author Mr.ml
 * @date 2021/7/15
 *
 * 给你链表的头结点head，请将其按升序排列并返回排序后的链表。
 * 进阶：
 * 你可以在O(nlogn)时间复杂度和常数级空间复杂度下，对链表进行排序吗？
 */
public class Solution_148_SortList {

    public ListNode sortList(ListNode head) {
        int n = 0;
        for (ListNode p = head; p != null; p = p.next) {
            n++;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        for (int i = 1; i < n; i *= 2) {
            ListNode begin = dummy;
            for (int j = 0; j + i < n; j += 2 * i) {
                ListNode first = begin.next, second = first;
                for (int k = 0; k < i; k++) {
                    second = second.next;
                }
                // firstIndex表示第一段的下标、secondIndex表示第二段的下标
                int firstIndex = 0, secondIndex = 0;
                // 合并
                while (firstIndex < i && secondIndex < i && second != null) {
                    if (first.val < second.val) {
                        begin.next = first;
                        begin = begin.next;
                        first = first.next;
                        firstIndex++;
                    } else {
                        begin.next = second;
                        begin = begin.next;
                        second = second.next;
                        secondIndex++;
                    }
                }
                // 第一段还有剩余
                while (firstIndex < i) {
                    begin.next = first;
                    begin = begin.next;
                    first = first.next;
                    firstIndex++;
                }
                // 第二段还有剩余
                while (secondIndex < i && second != null) {
                    begin.next = second;
                    begin = begin.next;
                    second = second.next;
                    secondIndex++;
                }
                begin.next = second;
            }
        }
        return dummy.next;
    }

}
