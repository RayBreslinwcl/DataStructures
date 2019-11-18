package com.DataStructures._02ArraysStackAndQueue;

/**
 * Created by Administrator on 2018/12/13.
 */
public interface _05queue<E> {
    int getSize();
    boolean isEmpty();
    void enqueue(E e);
    E dequeue();
    E getFront();
}
