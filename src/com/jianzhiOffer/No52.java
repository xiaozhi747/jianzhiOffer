package com.jianzhiOffer;

/**
 * 两个链表的第一个公共节点
 *
 * 输入两个链表，找出它们的第一个公共结点。
 *
 * Created by 林智 on 2018/6/21.
 */
public class No52 {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 更精练的代码
     *
     * 2个无环链表求相交的函数
     * @param head1
     * @param head2
     * @return	第一个相交的节点  若不相交则返回 null
     */
    public ListNode FindFirstCommonNode2(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        ListNode cur1 = head1;
        ListNode cur2 = head2;
        int n = 0;
        while (cur1.next != null) {
            n++;
            cur1 = cur1.next;
        }
        while (cur2.next != null) {
            n--;
            cur2 = cur2.next;
        }
        // 如果当2个链表都走到链表尾部的时候值不相同, 则说明2个链表并没有相交
        if (cur1 != cur2) {
            return null;
        }
        cur1 = n > 0 ? head1 : head2;			// 找出长的链表的头结点    同时复用变量
        cur2 = cur1 == head1 ? head2 : head1;	// 找出短链表的头结点
        n = Math.abs(n);	// 求绝对值
        while (n != 0) {
            n--;
            cur1 = cur1.next;
        }
        while (cur1 != cur2) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;	// 返回第一个相交的节点
    }

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        int length1 = 0;
        int length2 = 0;
        ListNode node = pHead1;
        while (node != null) {
            length1++;
            node = node.next;
        }
        node = pHead2;
        while (node != null) {
            length2++;
            node = node.next;
        }
        int length = length1 - length2;
        if (length > 0) {   // 说明 链表1 比较长, 那么让 链表1 先走 length 步
            while (length > 0) {
                pHead1 = pHead1.next;
                length--;
            }
        } else if (length < 0){ // // 说明 链表2 比较长, 那么让 链表2 先走 length 步
            length = Math.abs(length);
            while (length > 0) {
                pHead2 = pHead2.next;
                length--;
            }
        }
        while (pHead1 != null) {
            if (pHead1 == pHead2) {
                return pHead1;
            }
            pHead1 = pHead1.next;
            pHead2 = pHead2.next;
        }
        return null;
    }

}
