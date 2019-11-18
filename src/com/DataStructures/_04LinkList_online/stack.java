package com.DataStructures._04LinkList_online;

/**
 * Created by Administrator on 2018/12/12.
 */
public interface stack<E> {
    int getSize(); //获得元素个数
    boolean isEmpty();  //判断是否有元素
    void push(E e); //进栈
    E pop(); //出栈
    E peek(); //查询最顶端值
}
