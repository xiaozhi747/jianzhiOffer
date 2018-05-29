package com.jianzhiOffer;

/**
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，
 * 另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的 head。
 * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 *
 * Created by 林智 on 2018/5/28.
 */
public class No35 {
    public static class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

    public static RandomListNode Clone(RandomListNode head) {
        if (head == null) {
            return null;
        }
        cloneNextNodes(head);
        cloneRandomNodes(head);
        return reconnectNodes(head);
    }

    private static void cloneNextNodes(RandomListNode head) {
        RandomListNode node = head;
        while (node != null) {
            RandomListNode cloneNode = new RandomListNode(node.label);
            cloneNode.next = node.next;
            node.next = cloneNode;
            node = cloneNode.next;
        }
    }

    private static void cloneRandomNodes(RandomListNode head) {
        RandomListNode node = head;
        while (node != null) {
            RandomListNode cloneNode = node.next;
            if (node.random != null) {
                cloneNode.random = node.random.next;
            }
            node = cloneNode.next;
        }
    }

    /**
     * 把复制的节点与原链表节点分离开来
     */
    private static RandomListNode reconnectNodes(RandomListNode head) {
        RandomListNode node = head;
        RandomListNode cloneHead = null;
        RandomListNode cloneNode = null;

        if (node != null) {
            cloneHead = node.next;
            cloneNode = node.next;
            node.next = cloneNode.next;
            node = node.next;
        }
        while (node != null) {
            cloneNode.next = node.next;
            cloneNode = cloneNode.next;
            node.next = cloneNode.next;
            node = node.next;
        }
        return cloneHead;
    }

    public static void main(String[] args) {
        RandomListNode head = new RandomListNode(1);
        head.next = new RandomListNode(2);
        head.next.next = new RandomListNode(3);
        head.next.next.next = new RandomListNode(4);
        head.next.next.next.next = new RandomListNode(5);
        cloneNextNodes(head);
        while (head != null) {
            System.out.println(head.label);
            head = head.next;
        }
    }



}
