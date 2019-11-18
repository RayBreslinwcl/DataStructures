package com.DataStructures._02ArraysStackAndQueue;

/**
 * Created by Administrator on 2018/12/12.
 */
public interface _01stack<E> {
    //查看栈里一共有多少元素
    int getSize();
    //判断是否为空
    boolean isEmpty();
    //入栈：向栈顶添加元素
    void push(E e);
    //出栈：从栈顶取出元素
    E pop();
    //查看栈顶元素
    E peek();
}
