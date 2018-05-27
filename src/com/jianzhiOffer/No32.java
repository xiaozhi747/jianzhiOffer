package com.jianzhiOffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 *
 * 拓展一 : 在 Print() 中实现
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 *
 * 拓展二 : 在 Print2() 中实现
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，
 * 第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 *
 * 三个题目的思路都很相似
 *
 * Created by 林智 on 2018/5/25.
 */
public class No32 {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (root == null) {
            return list;
        }
        queue.add(root);
        while (!queue.isEmpty()) {
            root = queue.poll();
            list.add(root.val);
            if (root.left != null) {
                queue.add(root.left);
            }
            if (root.right != null) {
                queue.add(root.right);
            }
        }
        return list;
    }

    ArrayList<ArrayList<Integer> > Print(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int nextLevel = 0;  // 下一层节点的数目
        int toBePrint = 1;  // 当前层中还未打印的节点数
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            list.add(node.val);
            if (node.left != null) {
                queue.add(node.left);
                nextLevel++;
            }
            if (node.right != null) {
                queue.add(node.right);
                nextLevel++;
            }
            toBePrint--;
            if (toBePrint == 0) {
                result.add(list);
                list = new ArrayList<Integer>();
                toBePrint = nextLevel;
                nextLevel = 0;
            }
        }
        return result;
    }

    public ArrayList<ArrayList<Integer>> Print2(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> oddStack = new Stack<TreeNode>();  // 当遍历到奇数层时用这个栈
        Stack<TreeNode> evenStack = new Stack<TreeNode>(); // 当遍历到偶数层时用这个栈
        int levelNumber = 1;
        int nextLevelNodeNumber = 0;
        int toBePrint = 1;  // 当前层中还未打印的节点数
        oddStack.add(root);
        while (!oddStack.isEmpty() || !evenStack.isEmpty()) {
            // 奇数层
            if ((levelNumber & 1) == 1) {
                TreeNode node = oddStack.pop();
                list.add(node.val);
                if (node.left != null) {
                    evenStack.add(node.left);
                    nextLevelNodeNumber++;
                }
                if (node.right != null) {
                    evenStack.add(node.right);
                    nextLevelNodeNumber++;
                }
                toBePrint--;
            } else { // 偶数层
                TreeNode node = evenStack.pop();
                list.add(node.val);
                if (node.right != null) {
                    oddStack.add(node.right);
                    nextLevelNodeNumber++;
                }
                if (node.left != null) {
                    oddStack.add(node.left);
                    nextLevelNodeNumber++;
                }
                toBePrint--;
            }
            if (toBePrint == 0) {
                result.add(list);
                list = new ArrayList<Integer>();
                toBePrint = nextLevelNodeNumber;
                nextLevelNodeNumber = 0;
                levelNumber++;
            }
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println(PrintFromTopToBottom(null));
    }
}
