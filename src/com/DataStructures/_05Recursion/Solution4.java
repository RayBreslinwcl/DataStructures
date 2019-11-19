package com.DataStructures._05Recursion;
/// Leetcode 203. Remove Linked List Elements
/// https://leetcode.com/problems/remove-linked-list-elements/description/
//方法二
class Solution4 {

    public ListNode removeElements(ListNode head, int val) {
        if(head==null){
            return null;
        }

        head.next=removeElements(head.next,val);
//        if(head.val==val){
//            return head.next;
//        }else {
//            return head;
//        }
       //等效
        return head.val==val?head.next:head;
    }


}