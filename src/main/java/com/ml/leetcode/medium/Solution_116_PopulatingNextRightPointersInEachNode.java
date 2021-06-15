package com.ml.leetcode.medium;

/**
 * @author Mr.ml
 * @date 2021/6/10
 *
 * 给定一个完美二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
 *
 * struct Node {
 *     int val;
 *     Node *left;
 *     Node *right;
 *     Node *next;
 * }
 *
 * 填充它的每个next指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将next指针设置为NULL。
 * 初始状态下，所有next指针都被设置为NULL。
 *
 * 这道题的解法非常巧妙，可以采用递归+使用已建立的next指针的思路解题，因为next指针是一层一层连接的，
 * 所以在连接本层的next指针的时候可以利用上一层的next指针，加上特殊的满二叉树结构，当前节点的左子节点
 * 的next节点为当前节点的右子节点，当前节点的右子节点的next节点可以借助当前节点的next节点构建，
 * 当前节点的next节点为null时，当前节点的右子节点的next节点也为null，否则为当前节点的next节点的左子节点。
 */
public class Solution_116_PopulatingNextRightPointersInEachNode {

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        if (root.left != null) {
            root.left.next = root.right;
            root.right.next = root.next == null ? null : root.next.left;
            connect(root.left);
            connect(root.right);
        }
        return root;
    }

}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}