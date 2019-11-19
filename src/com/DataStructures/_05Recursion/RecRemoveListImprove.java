package com.DataStructures._05Recursion;
/// Leetcode 203. Remove Linked List Elements
/// https://leetcode.com/problems/remove-linked-list-elements/description/
//方法一:递归法，删除链表制定节点
class RecRemoveListImprove {

    public ListNode removeElements(ListNode head, int val) {
        if(head==null)
            return null;

//        ListNode res=removeElements(head.next,val);
//        if(head.val==val){
//            return res;
//        }else {
//            head.next=res;
//            return head;
//        }
        //简化代码
        head.next=removeElements(head.next,val);
        return head.val==val?head.next:head;
    }

    public static void main(String[] args) {
        int[] nums={1,2,3,4,6,43,23};
        ListNode head=new ListNode(nums);
        System.out.println(head);

        ListNode res= new RecRemoveListImprove().removeElements(head,6);
        System.out.println(res);
    }

}