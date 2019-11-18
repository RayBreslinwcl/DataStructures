package com.DataStructures._02ArraysStackAndQueue_online;

/**
 * Created by Administrator on 2018/12/12.
 */
public class ArrayStack<E> implements stack<E> {
    ArrayDynamic<E> array;

    //*********************************************************************************
    //1.构造函数
    public ArrayStack(int Capacity){
        array=new ArrayDynamic<>(Capacity);
    }
    public ArrayStack(){
        array=new ArrayDynamic<>();
    }

    //*********************************************************************************
    //2.基本信息
    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    public int getCapacity(){
        return array.getCapacity();
    }
    //*********************************************************************************

    /**
     * 3.进栈
     * @param e
     */
    @Override
    public void push(E e) {
        array.addLast(e);
    }
    //*********************************************************************************
    /**
     * 4.出栈
     * @return
     */
    @Override
    public E pop() {
        return array.removeLast();
    }

    //*********************************************************************************
    /**
     * 4.1 查询最顶端元素
     * @return
     */
    @Override
    public E peek() {
        return array.getLast();
    }

    //*********************************************************************************
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




