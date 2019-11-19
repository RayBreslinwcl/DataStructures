package com.DataStructures._05Recursion;

/**
 * Created by Administrator on 2018/12/15.
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    //链表结点构造函数
    //使用数组arr为输入，创建一个链表，链表每个节点值为arr数组的每一个值
    public ListNode(int[] arr){

        if(arr==null || arr.length==0)
            throw new IllegalArgumentException("arr can not be empty");

        this.val=arr[0];
        ListNode current=this;
        for (int i=1;i<arr.length;i++){
            current.next=new ListNode(arr[i]);
            current=current.next;
        }
    }

    //以当前节点为头节点的链表的信息字符串
    @Override
    public String toString() {

        StringBuilder res=new StringBuilder();
        ListNode cur=this;
        while (cur!=null){
            res.append(cur.val+"->");
            cur=cur.next;
        }
        res.append("Null");
        return res.toString();
    }
}
