package com.DataStructures._07Set;

/**
 * Created by Administrator on 2018/12/17.
 */
public interface Set<E> {
    void add(E e);
    void remove(E e);
    boolean contains(E e);
    int getSize();
    boolean isEmpty();
}
