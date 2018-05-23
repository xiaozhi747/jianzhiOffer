package com.jianzhiOffer;

/**
 * 题目： 输入一个链表。输出该链表中倒数第 k 个结点。
 * 为了符合大多数人的习惯，本题从 1 開始计数。即链表的尾结点是倒数第 1 个结点。
 * 比如一个链表有 6 个结点。从头结点開始它们的值依次是 1, 2, 3, 4, 5, 6 这个链表的
 * 倒数第 3 个结点是值为 4 的结点
 *
 * Created by 林智 on 2018/5/23.
 */
public class No22 {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode FindKthToTail(ListNode head,int k) {
        if (head == null || k <= 0) {
            return null;
        }
        ListNode n1 = head;
        ListNode n2 = head;
        for (int i = 0; i < k - 1; i++) {
            // 注意条件、边界
            if (n1.next != null) {
                n1 = n1.next;
            } else {
                return null;
            }
        }
        // 注意条件、边界
        while (n1.next != null) {
            n2 = n2.next;
            n1 = n1.next;
        }
        return n2;
    }
}
