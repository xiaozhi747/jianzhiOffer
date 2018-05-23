package com.jianzhiOffer;

/**
 * Created by 林智 on 2018/5/23.
 */
public class No23 {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode EntryNodeOfLoop(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }
        // 慢指针一次走一步
        ListNode n1 = head.next;
        // 快指针一次走两步
        ListNode n2 = head.next.next;
        // n2 是否为空已经判断过了
        while (n2.next != null && n2.next.next != null) {
            if (n1 == n2) {
                break;
            }
            n1 = n1.next;
            n2 = n2.next.next;
        }
        // 不相等则说明链表无环, 相等则说明有环
        if (n1 != n2) {
            return null;
        }
        // 快指针回到头部后, n1 n2 同时开始走, 每次都走一步, 必定在入环口相遇
        n2 = head;
        while (n1 != n2) {
            n1 = n1.next;
            n2 = n2.next;
        }
        return n1;
    }
}
