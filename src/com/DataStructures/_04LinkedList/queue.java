package com.DataStructures._04LinkedList;

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
