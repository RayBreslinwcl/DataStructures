package com.DataStructures._04LinkedList;

/**
 * Created by Administrator on 2018/12/12.
 */
public interface stack<E> {
    int getSize();
    boolean isEmpty();
    void push(E e);
    E pop();
    E peek();
}
