package com.DataStructures._02ArraysStackAndQueue;

/**
 * Created by Administrator on 2018/12/12.
 */
public class _02ArrayStack<E> implements _01stack<E> {
    _00ArrayDynamic<E> array;

    public _02ArrayStack(int Capacity){
        array=new _00ArrayDynamic<>(Capacity);
    }
    public _02ArrayStack(){
        array=new _00ArrayDynamic<>();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public void push(E e) {
        array.addLast(e);
    }

    @Override
    public E pop() {
        return array.removeLast();
    }

    @Override
    public E peek() {
        return array.getLast();
    }

    public int getCapacity(){
        return array.getCapacity();
    }

    public String toString(){
        StringBuilder res=new StringBuilder();
        res.append("Stack:[");
        for (int i=0;i<array.getSize();i++){
            res.append(array.get(i));
            if (i!=array.getSize()){
                res.append(",");
            }
        }
        res.append("]");
        return res.toString();

    }
}
