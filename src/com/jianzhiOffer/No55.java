package com.jianzhiOffer;

/**
 * 题目一：二叉树的深度
 *
 * 输入一棵二叉树，求该树的深度。
 * 从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 *
 *
 * 题目二：平衡二叉树
 *
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 * 如果某二叉树中任意节点的左、右子树的深度相差不超过 1，那么它就是一棵平衡二叉树
 *
 * Created by 林智 on 2018/6/25.
 */
public class No55 {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 题目一
     */
    public int TreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = TreeDepth(root.left);
        int right = TreeDepth(root.right);
        return left > right ? left + 1 : right + 1;
    }

    /**
     * 题目二
     */
    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isBalanced(root) != -1;
    }

    private int isBalanced(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = isBalanced(root.left);
        if (left == -1) {
            return -1;
        }
        int right = isBalanced(root.right);
        if (right == -1) {
            return -1;
        }
        return Math.abs(left - right) > 1 ? -1 : 1 + Math.max(left, right);
    }

}
