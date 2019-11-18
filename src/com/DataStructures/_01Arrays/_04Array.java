package com.DataStructures._01Arrays;

/**
 * Created by Administrator on 2018/12/10.
 */
public class _04Array {
    private int[] data; //数组
    private int size; //数组中实际元素个数

    //构造函数，传入数组的容量capacity
    public _04Array(int capacity){
        data=new int[capacity];
        size=0;
    }

    //无参数构造函数，默认数组的容量10
    public _04Array(){
        this(10);
    }

    //获取数组容量
    public int getCapacity(){
        return data.length;
    }
    //获取数组中的元素个数
    public int getSize(){
        return size;
    }
    //返回数组是否为空
    public boolean isEmpty(){
        return size==0;
    }

    //向所有元素后添加一个新元素
    public void addLast(int e){
        if (size==data.length){
            throw new IllegalArgumentException("AddLast failed. Array is full.");

        }
        data[size] = e;
        size ++;
    }
    //在所有元素前添加一个新元素
    public void addFirst(int e){
        add(0,e);
    }
    //在index索引位置插入一个新元素
    public void add(int index,int e){
        if(size==data.length){
            throw new IllegalArgumentException("AddLast failed. Array is full.");
        }
        if(index<0||index>size){
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size.");
        }
        for (int i =size-1;i>=index;i--){
            data[i+1]=data[i];
        }
        data[index]=e;
        size++;

    }

    @Override
    public String toString(){
        StringBuilder res=new StringBuilder();
        res.append(String.format("Array:size=%d,capacity=%d\n",size,data.length));
        res.append("[");
        for (int i =0;i<size;i++){
            res.append(data[i]);
            if(i!=size-1){
                res.append(",");
            }
        }
        res.append("]");

        return res.toString();
    }

    public int get(int index){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        }
        return data[index];
    }

    public void set(int index,int e){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        }
        data[index]=e;
    }
}
