package com.jianzhiOffer;

/**
 * 在 O(1) 的时间内删除链表节点
 * 给定单向链表的头指针和一个节点指针, 定义一个函数在 O(1) 时间内删除该节点.
 *
 * Created by 林智 on 2018/5/19.
 */
public class No18 {

    /**
     * 链表的定义
     */
    class ListNode {
        int value;
        ListNode next;
    }

    void DeleteNode(ListNode head, ListNode toBeDeleted) {
        if (head == null || toBeDeleted == null) {
            return;
        }
        if (toBeDeleted.next != null) {
            ListNode next = toBeDeleted.next;
            toBeDeleted.value = next.value;
            toBeDeleted.next = next.next;
            next = null;
        } else if (head == toBeDeleted) {
            head = null;
            toBeDeleted = null;
        } else {
            ListNode next = head.next;
            while (next != null) {
                next = next.next;
            }
            next.next = null;
            toBeDeleted = null;
        }
    }
}
