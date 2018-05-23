package com.jianzhiOffer;

/**
 * 输入两个递增排序的链表, 合并这两个链表并使新链表中的节点仍然是递增排序的.
 * 返回合并后的链表的头节点
 *
 * Created by 林智 on 2018/5/23.
 */
public class No25 {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 递归版
     */
    public ListNode Merge(ListNode head1,ListNode head2) {
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        ListNode head = null;
        if (head1.val < head2.val) {
            head = head1;
            head.next = Merge(head1.next, head2);
        } else if (head1.val >= head2.val){
            head = head2;
            head.next = Merge(head1, head2.next);
        }
        return head;
    }

    /**
     * 非递归版
     * copy from nowcoder.com
     */
    public ListNode Merge2(ListNode list1,ListNode list2) {
        if(list1 == null)return list2;
        if(list2 == null)return list1;
        ListNode pre=null,temp=null,cur1=list1,cur2=list2;
        while(list1 !=null&& cur2 != null){
            while(cur1!=null){
                if(cur1.val<=cur2.val){
                    pre=cur1;
                    cur1=cur1.next;
                }else {
                    break;
                }
            }
            temp = cur2;
            cur2=cur2.next;
            insert(pre,temp);
            pre = temp;
            cur1=pre.next;
        }
        //if(cur2 != null)pre.next=cur2;
        while (cur2 != null) {
            insert(pre, cur2);
            cur2 = cur2.next;
        }
        return list1;
    }

    public void insert(ListNode pre,ListNode temp){
        if(pre == null || temp == null)return;
        temp.next=pre.next;
        pre.next=temp;
    }
}
