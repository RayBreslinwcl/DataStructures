package com.DataStructures._05Recursion;

/**
 * Created by Administrator on 2018/12/15.
 * 功能：删除值为val的所有
 * 使用虚拟头节点-代码更加简洁
 */
public class solution2 {
    public ListNode removeElements(ListNode head, int val) {

        ListNode dummyHead=new ListNode(-1);//赋值随意
        dummyHead.next=head;
//
//        while (head!=null&&head.val==val){
//            ListNode delnode=head;
//            head=head.next;
//            delnode.next=null;
//        }
//
//        if(head == null)
//            return head;

        ListNode prev=dummyHead;
        while (prev.next!=null){
            if(prev.next.val==val){
                ListNode delNode=prev.next;
                prev.next=delNode.next;
                delNode.next=null;
            }else {
                prev=prev.next;
            }
        }
        return dummyHead.next;

    }
}
