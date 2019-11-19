package com.DataStructures._05Recursion;

/**
 * Created by Administrator on 2018/12/15.
 * 功能：删除值为val的所有
 * 不使用虚拟头节点
 */
public class solution1 {
    public ListNode removeElements(ListNode head, int val) {
        //在开始第一个需要删除，则是这个情况
        while (head!=null&&head.val==val){
            ListNode delnode=head;
            head=head.next;
            delnode.next=null;
        }

        if(head == null)
            return head;

        ListNode prev=head;
        while (prev.next!=null){
            if(prev.next.val==val){
                ListNode delNode=prev.next;
                prev.next=delNode.next;
                delNode.next=null;
            }else {
                prev=prev.next;
            }
        }
        return head;


    }
}
