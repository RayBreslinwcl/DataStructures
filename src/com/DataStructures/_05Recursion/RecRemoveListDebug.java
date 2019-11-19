package com.DataStructures._05Recursion;

import java.util.List;

/// Leetcode 203. Remove Linked List Elements
/// https://leetcode.com/problems/remove-linked-list-elements/description/
//方法一:递归法，删除链表制定节点
//调试递归函数改进
class RecRemoveListDebug {


    //添加递归深度参数，查看递归流程
    public ListNode removeElements(ListNode head, int val,int depth) {
        //依据深度产生字符串的长度
        String depthString=generateDepthString(depth);
        System.out.print(depthString);
        System.out.println("Call: remove "+val+ " in "+head);

        if(head==null){
            System.out.print(depthString);
            System.out.println("Return: "+head);
//            return null;
            return head;
        }
//        ListNode res=removeElements(head.next,val);
//        if(head.val==val){
//            return res;
//        }else {
//            head.next=res;
//            return head;
//        }
        //简化代码
//        head.next=removeElements(head.next,val,depth+1);

        ListNode results=removeElements(head.next,val,depth+1);
        //如果该节点包含指定值，在删除指定节点之前
        System.out.print(depthString);
        System.out.println("Before remove "+ val+ ": "+ head);

        //在删除指定节点之后
        System.out.print(depthString);
        System.out.println("After remove "+ val+ ": "+ results);

        ListNode ret;
        if (head.val==val){
            ret=results;
        }else {
            head.next=results;
            ret=head;
        }
        System.out.print(depthString);
        System.out.println("Return: "+ ret);


//        return head.val==val?head.next:head;
        return ret;
    }

    //依据运行深度，打印对应长度的==符号
    private String generateDepthString(int depth){
        StringBuilder res=new StringBuilder();
        for (int i=0;i<depth;i++){
            res.append("==");
        }
        return res.toString();
    }



    public static void main(String[] args) {
        int[] nums={1,2,3,4,6,43,23};
        ListNode head=new ListNode(nums);
        System.out.println(head);

        ListNode res= new RecRemoveListDebug().removeElements(head,6,1);
        System.out.println(res);
    }

}