package com.jianzhiOffer;

/**
 *
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 *
 * Created by 林智 on 2018/5/14.
 */
public class No7 {
    /**
     * Definition for binary tree
     */
    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }


    public static TreeNode reConstructBinaryTree(int [] pre, int [] in) {
        if (pre == null || in == null || pre.length == 0 || in.length == 0) {
            return null;
        }
        return reConstructBinaryTree(pre, in, 0, pre.length - 1, 0, in.length - 1);
    }

    public static TreeNode reConstructBinaryTree(int[] pre, int[] in, int preStart,
                                          int preEnd, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        int value = pre[preStart];
        int inRootIndex = inStart;
        while (value != in[inRootIndex] && inEnd > inStart) {
            inRootIndex++;
        }
        if (inStart > inEnd) {
            return null;
        }

        TreeNode node = new TreeNode(value);
        node.left = reConstructBinaryTree(pre, in, preStart + 1,
                preStart + inRootIndex - inStart, inStart, inRootIndex - 1);
        node.right = reConstructBinaryTree(pre, in, preStart + inRootIndex - inStart + 1,
                preEnd, inRootIndex + 1, inEnd);
        return node;
    }

    public static void main(String[] args) {
        int[] pre = {1,2,3,4,5,6,7};
        int[] in = {3,2,4,1,6,5,7};
        System.out.println(reConstructBinaryTree(pre, in));
    }
}
