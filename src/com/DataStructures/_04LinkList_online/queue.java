package com.DataStructures._04LinkList_online;

/**
 * Created by Administrator on 2018/12/13.
 */
public interface queue<E> {
    int getSize();
    boolean isEmpty();
    void enqueue(E e);
    E dequeue();
    E getFront();
}
