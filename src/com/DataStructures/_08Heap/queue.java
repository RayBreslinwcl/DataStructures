package com.DataStructures._08Heap;

/**
 * Created by Administrator on 2018/12/13.
 */
public interface queue<E> {
    int getSize();
    //判断是否非空
    boolean isEmpty();
    //入队
    void enqueue(E e);
    //出队
    E dequeue();
    //获取最前面的元素
    E getFront();
}
