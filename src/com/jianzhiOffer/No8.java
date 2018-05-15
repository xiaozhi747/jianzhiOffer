package com.jianzhiOffer;

/**
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 *
 * Created by 林智 on 2018/5/15.
 */
public class No8 {

    public class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        // next 表示指向父节点的引用, emmmm 牛客网的命名比较坑
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }

    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null) {
            return null;
        }
        TreeLinkNode cur = pNode;
        if (cur.right != null) {
            cur = cur.right;
            while (cur.left != null) {
                cur = cur.left;
            }
            return cur;
        } else if (cur.next != null) {
            TreeLinkNode parent = cur.next;
            while (parent != null && cur == parent.right) {
                cur = parent;
                parent = cur.next;
            }
            return parent;
        }
        return null;
    }

}
