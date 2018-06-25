package com.jianzhiOffer;

import java.util.ArrayList;

/**
 * 二叉搜索树的第 K 大节点
 *
 * 给定一颗二叉搜索树，请找出其中的第k小的结点。
 * 例如，
 *       5
 *      / \
 *     3   7
 *    /\   /\
 *   2 4  6 8
 *              中，
 *   按结点数值大小顺序第三个结点的值为4。
 *
 * Created by 林智 on 2018/6/25.
 */
public class No54 {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    int index = 0;

    /**
     * 最优解
     */
    TreeNode KthNode(TreeNode root, int k) {
        if (root == null || k <= 0) {
            return null;
        }
        index = k;
        return KthNodeCore(root);
    }

    private TreeNode KthNodeCore(TreeNode root) {
        TreeNode target = null;
        if (root.left != null) {
            target = KthNodeCore(root.left);
        }
        if (target == null) {
            if (index == 1) {
                target = root;
            }
            index--;
        }
        if (target == null && root.right != null) {
            target = KthNodeCore(root.right);
        }
        return target;
    }


    /**
     * 思路不错的一个解, 比最优解多了一个 O(N) 的额外空间开销
     */
    TreeNode KthNode2(TreeNode pRoot, int k)
    {
        if(k<=0)
            return null;
        ArrayList<TreeNode> inOrderList = new ArrayList<TreeNode>();
        InOrder(pRoot, inOrderList);
        if(inOrderList.size() < k)
            return null;
        return inOrderList.get(k-1);
    }

    /**
     * 用中序遍历的顺序把所有节点都加入到 list 中, 然后取出在 list 集合中对第 k 个加入的数
     */
    void InOrder(TreeNode root, ArrayList<TreeNode> inOrderList){
        if(root==null)
            return;
        InOrder(root.left, inOrderList);
        inOrderList.add(root);
        InOrder(root.right, inOrderList);
    }

}
