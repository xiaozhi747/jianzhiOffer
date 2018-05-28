package com.jianzhiOffer;

import java.util.ArrayList;

/**
 * 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 注意: 路径定义为从 树的根结点 开始往下一直到 叶结点 所经过的结点形成一条路径。
 *
 * Created by 林智 on 2018/5/28.
 */
public class No34 {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    private ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null) {
            return result;
        }
        ArrayList<Integer> curList = new ArrayList<Integer>();
        return FindPath(root, target, curList, 0);
    }

    public ArrayList<ArrayList<Integer>> FindPath
            (TreeNode root, int target, ArrayList<Integer> curList,
             int currentSum) {
        currentSum += root.val;
        curList.add(root.val);
        TreeNode node = root;
        if (currentSum == target && (node.left == null && node.right == null)) {
            result.add(curList);
        }
        if (node.left != null) {
            FindPath(node.left, target, (ArrayList<Integer>)curList.clone(), currentSum);
        }
        if (node.right != null) {
            FindPath(node.right, target, (ArrayList<Integer>)curList.clone(), currentSum);
        }
        return result;
    }
}
