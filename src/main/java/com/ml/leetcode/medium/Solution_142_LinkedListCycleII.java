package com.ml.leetcode.medium;

/**
 * @author Mr.ml
 * @date 2021/6/27
 *
 * 给定一个链表，返回链表开始入环的第一个节点。如果链表无环，则返回null。
 * 为了表示给定链表中的环，我们使用整数pos来表示链表尾连接到链表中的位置（索引从0开始）。
 * 如果pos是-1，则在该链表中没有环。注意，pos仅仅是用于标识环的情况，并不会作为参数传递到函数中。
 * 说明：不允许修改给定的链表。
 * 进阶：
 * 你是否可以使用O(1)空间解决此题？
 */
public class Solution_142_LinkedListCycleII {

    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while (true) {
            if (fast == null || fast.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
            // 此时fast走过的步数等于slow走过的步数的两倍
            // fast = 2slow
            // 因为fast比slow多走了n个环的长度，所以fast = slow + nb
            // slow = nb
            // fast = 2nb
            if (fast == slow) {
                break;
            }
        }
        // 将fast指向头节点，也就是将fast置为0
        fast = head;
        while (slow != fast) {
            // slow和fast同时每轮向前走1步
            // 当fast = a时，slow = a + nb，此时两指针重合，并同时指向链表环入口
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}