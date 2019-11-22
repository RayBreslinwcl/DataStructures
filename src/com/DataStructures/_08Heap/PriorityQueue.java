package com.DataStructures._08Heap;

/**
 * Created by Administrator on 2018/12/20.
 * 优先队列实现
 */
public class PriorityQueue<E extends Comparable<E>> implements queue<E> {

    //1.最大堆结构
    private MaxHeap<E> maxHeap;

    //2.构造函数
    public PriorityQueue(){
        maxHeap=new MaxHeap<E>();
    }

    //3.获得基本信息
    @Override
    public int getSize() {
        return maxHeap.size();
    }

    @Override
    public boolean isEmpty() {
        return maxHeap.isEmpty();
    }

    //*************************************************************
    //4.查询最顶端元素
    /**
     * 查询最顶端元素
     * @return
     */
    @Override
    public E getFront() {
        return maxHeap.findMax();
    }

    //*************************************************************
    //5.入队
    /**
     * 入队
     * @param e
     */
    @Override
    public void enqueue(E e) {
        maxHeap.add(e);
    }

    //*************************************************************
    //6.出队
    /**
     * 出队
     * @return
     */
    @Override
    public E dequeue() {
        return maxHeap.extractMax();
    }


}
