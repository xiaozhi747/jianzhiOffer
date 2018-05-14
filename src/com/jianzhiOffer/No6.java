package com.jianzhiOffer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by 林智 on 2018/5/14.
 */
public class No6 {
    public class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
        }
    }


    ArrayList<Integer> arrayList = new ArrayList<Integer>();
    /**
     * 递归版
     */
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if (listNode != null) {
            printListFromTailToHead(listNode.next);
            arrayList.add(listNode.val);
        }
        return arrayList;
    }


    ArrayList<Integer> resultList = new ArrayList<Integer>();
    /**
     * 非递归版
     */
    public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        Stack<Integer> stack = new Stack<Integer>();
        while (listNode != null) {
            stack.add(listNode.val);
            listNode = listNode.next;
        }

        while (!stack.isEmpty()) {
            resultList.add(stack.pop());
        }

        return resultList;
    }
}
