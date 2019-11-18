package com.DataStructures._04LinkedList;

/**
 * Created by Administrator on 2018/12/15.
 */
public class LinkedListStack<E> implements stack<E> {
    private LinkedDummyHeadList<E> list;

    public LinkedListStack(){
        list=new LinkedDummyHeadList<>();
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void push(E e) {
        list.addFirst(e);
    }

    @Override
    public E pop() {
//        return null;
        return list.removeFirst();
    }

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
