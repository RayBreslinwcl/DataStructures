package com.DataStructures._02ArraysStackAndQueue_online;


/**
 * Created by Administrator on 2018/12/13.
 */
public class ArrayQueue<E> implements queue<E> {
    private ArrayDynamic<E> array;
    //******************************************************************
    //1.构造函数
    public ArrayQueue(int capacity){
        array=new ArrayDynamic<>(capacity);
    }
    public ArrayQueue(){
        array=new ArrayDynamic<>();
    }
    //******************************************************************
    //2.获得基本信息
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

    //******************************************************************
    //3.入队
    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }
    //******************************************************************
    //4.出队
    @Override
    public E dequeue() {
        return array.removeFirst();
    }
    //******************************************************************
    //5.获得第一个入队
    @Override
    public E getFront() {
        return array.getFirst();
    }

    public String toString(){
        StringBuilder res=new StringBuilder();
        res.append("Queue:");
        res.append("front [");
        for (int i=0;i<array.getSize();i++){
            res.append(array.get(i));
            if (i!=array.getSize()-1){
                res.append(", ");
            }
        }
        res.append("] tail");
        return res.toString();
    }

}
