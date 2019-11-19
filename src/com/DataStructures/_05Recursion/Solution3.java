package com.DataStructures._05Recursion;
/// Leetcode 203. Remove Linked List Elements
/// https://leetcode.com/problems/remove-linked-list-elements/description/
//方法一:递归法，删除链表制定节点
class Solution3 {

    public ListNode removeElements(ListNode head, int val) {
        if(head==null){
            return null;
        }

        ListNode res=removeElements(head.next,val);
        if(head.val==val){
            return res;
        }else {
            head.next=res;
            return head;
        }

    }


}