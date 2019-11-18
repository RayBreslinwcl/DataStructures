package com.DataStructures._01Arrays;

import java.lang.reflect.Array;

/**
 * Created by Administrator on 2018/12/10.
 */
public class _02Array {
    private int[] data; //数组
    private int size; //数组中实际元素个数

    //构造函数，传入数组的容量capacity
    public _02Array(int capacity){
        data=new int[capacity];
        size=0;
    }

    //无参数构造函数，默认数组的容量10
    public _02Array(){
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
}
