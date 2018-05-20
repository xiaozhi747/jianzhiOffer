package com.jianzhiOffer;

/**
 * 题目一: 在 DeleteNode() 中实现
 * 在 O(1) 的时间内删除链表节点
 * 给定单向链表的头指针和一个节点指针, 定义一个函数在 O(1) 时间内删除该节点.
 *
 * 题目二: 在 deleteDuplication() 中实现
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，
 * 返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 *
 * Created by 林智 on 2018/5/19.
 */
public class No18 {

    /**
     * 链表的定义
     */
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int value) {
            this.val = value;
        }
    }

    /**
     * 题目一
     * 在 O(1) 的时间内删除链表节点
     * 给定单向链表的头指针和一个节点指针, 定义一个函数在 O(1) 时间内删除该节点.
     */
    void DeleteNode(ListNode head, ListNode toBeDeleted) {
        if (head == null || toBeDeleted == null) {
            return;
        }
        if (toBeDeleted.next != null) {
            ListNode next = toBeDeleted.next;
            toBeDeleted.val = next.val;
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

    /**
     * 题目二: 在 deleteDuplication() 中实现
     * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，
     * 返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
     *
     * @return 返回修改后的链表头结点
     */
    public static ListNode deleteDuplication(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode preNode = null;
        ListNode curNode = head;
        while (curNode != null) {
            ListNode next = curNode.next;
            boolean needDelete = false;
            if (next != null && next.val == curNode.val) {
                needDelete = true;
            }
            if (!needDelete) {
                preNode = curNode;
                curNode = curNode.next;
            } else {
                int value = curNode.val;
                ListNode toBeDel = curNode;
                // 这里应当从 curNode 节点开始遍历, 而不该从 next 节点开始遍历, 否则最后一个节点很可能无法正确判断
                while (toBeDel != null && toBeDel.val == value) {
                    next = toBeDel.next;
                    toBeDel = toBeDel.next;
                }
                if (preNode == null) {
                    head = next;
                } else {
                    preNode.next = next;
                }
                curNode = next;
            }
        }
        return head;
    }

}
