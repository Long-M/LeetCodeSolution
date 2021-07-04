package com.ml.leetcode.medium;

/**
 * @author Mr.ml
 * @date 2021/6/24
 *
 * 给你二叉搜索树的根节点root，该树中的两个节点被错误地交换。请在不改变其结构的情况下，恢复这棵树。
 * 进阶：使用O(n)空间复杂度的解法很容易实现。你能想出一个只使用常数空间的解决方案吗？
 */
public class Solution_099_RecoverBinarySearchTree {

    public void recoverTree(TreeNode root) {
        // 记录错误的两个值
        TreeNode x = null, y = null;
        // 记录中序遍历当前节点的前驱
        TreeNode pre = null;
        // 用来完成Morris连接的寻找前驱的指针
        TreeNode predecessor = null;
        while (root != null) {
            // 左子树不为空
            // 1.链接root节点的前驱，他的前驱还没访问，所以root不能现在访问，继续访问root左子树
            // 2.root节点访问，并且断开root节点的前驱连接，然后访问root的右子树
            if (root.left != null) {
                // predecessor节点就是当前root节点向左走一步，然后一直向右走至无法走为止
                predecessor = root.left;
                // 遍历到左子树的最右侧节点
                while (predecessor.right != null && predecessor.right != root) {
                    predecessor = predecessor.right;
                }
                // 让predecessor的右指针指向root，继续遍历左子树
                // predecessor.right!=root，说明了还没执行过1
                if (predecessor.right == null) {
                    // 为了解决从子节点找到父节点的问题，临时修改树的结构，在遍历完成之后复原成原来的树结构
                    predecessor.right = root;
                    root = root.left;
                }
                // 说明左子树已经访问完了，我们需要断开连接
                // 说明了1已经执行过了，我们执行2
                else {
                    // 交换逻辑
                    if (pre != null && root.val < pre.val) {
                        y = root;
                        if (x == null) {
                            x = pre;
                        }
                    }
                    pre = root;

                    // 复原成原来的树结构
                    predecessor.right = null;
                    root = root.right;
                }
            }
            // 如果没有左孩子，则直接访问右孩子
            // root.left==null，root不需要链接节点的前驱（它的前驱其实就是pre（第一个节点pre为null），且已经被访问过了），那么直接访问root
            else {
                if (pre != null && root.val < pre.val) {
                    y = root;
                    if (x == null) {
                        x = pre;
                    }
                }
                pre = root;

                root = root.right;
            }
        }
        swap(x, y);
    }

    public void swap(TreeNode x, TreeNode y) {
        int tmp = x.val;
        x.val = y.val;
        y.val = tmp;
    }

}
