package com.DataStructures._04LinkList_online;


/**
 * Created by Administrator on 2018/12/15.
 */
public class LinkedListStack<E> implements stack<E> {
    private LinkedVirtualHeadList<E> list;

    //1.构造函数
    public LinkedListStack(){
        list=new LinkedVirtualHeadList<>();
    }

    //***********************************************************************
    //2.获得基本信息
    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    //***********************************************************************
    //3.入栈
    @Override
    public void push(E e) {
        list.addFirst(e);
    }
    //***********************************************************************
    //4.出栈
    @Override
    public E pop() {
//        return null;
        return list.removeFirst();
    }
    //***********************************************************************
    //5.查询栈顶元素
    @Override
    public E peek() {
        return list.getFirst();
    }

    public String toString(){
        StringBuilder res=new StringBuilder();
        res.append("Stack:top");
        res.append(list);
        return res.toString();

    }

    public static void main(String[] args) {
        LinkedListStack<Integer> stack=new LinkedListStack<>();

        for (int i =0;i<5;i++){
            stack.push(i);
            System.out.println(stack);
        }

        stack.pop();
        System.out.println(stack);

    }
}
