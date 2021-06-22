package com.ml.leetcode.easy;

/**
 * @author Mr.ml
 * @date 2021/6/22
 *
 * 给你两个单链表的头节点headA和headB，请你找出并返回两个单链表相交的起始节点。
 * 如果两个链表没有交点，返回null。
 *
 * 题目数据保证整个链式结构中不存在环。
 * 注意，函数返回结果后，链表必须保持其原始结构。
 *
 * 走到尽头见不到你，于是走过你来时的路，等到相遇时才发现，你也走过我来时的路。
 */
public class Solution_160_IntersectionOfTwoLinkedLists {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headA : pA.next;
            pB = pB == null ? headB : pB.next;
        }
        return pA;
    }

}
