package com.DataStructures._08Heap;

import java.util.Random;

/**
 * Created by Administrator on 2018/12/19.
 * 最大堆的实现：即每个节点都会大于其子节点的值
 * 实现基本原理：是从数组0开始的堆
 */
public class MaxHeap <E extends Comparable<E>>{
    //1.存储元素
    private ArrayDynamic<E> data;

    //2. 构造函数
    public MaxHeap(int capacity){
        data=new ArrayDynamic<E>(capacity);
    }
    public MaxHeap(){
        data=new ArrayDynamic<E>();
    }

    //3.基本信息
    //返回堆中的元素个数
    public int size(){
        return data.getSize();
    }

    //返回一个布尔值，表示堆中是否为空
    public boolean isEmpty(){
        return data.isEmpty();
    }

    //***********************************************************
    //4.辅助函数
    //返回完全二叉树的数组表示中，一个索引表示的元素的父亲节点的索引
    private int parent(int index){
        if(index==0){
            throw new IllegalArgumentException("index-0 doesn't have parent.");
        }
        return (index-1)/2;
    }

    //返回完全二叉树的数组中，一个索引表示的元素的左孩子节点的索引
    private int leftChild(int index){
        return index*2+1;
    }
    //返回完全二叉树的数组中，一个索引表示的元素的右孩子节点的索引
    private int rightChild(int index){
        return index*2+2;
    }
    //***********************************************************
    //5.向堆中添加元素
    public void add(E e){
        data.addLast(e);
        siftUp(data.getSize()-1);
    }

    //把该元素调整到正确位置
    private void siftUp(int k){
        while (k>0&&data.get(parent(k)).compareTo(data.get(k))<0){
            data.swap(k,parent(k));
            k=parent(k);
        }
    }
    //***********************************************************
    // 6.看堆中的最大元素
    public E findMax(){
        if (data.getSize()==0){
            throw new IllegalArgumentException("Can not findMax when heap is empty.");
        }
        return data.get(0);
    }
    //***********************************************************
    //7.从堆中取出元素
    //默认取出第一个，后续改造思路：把最后一个元素放到顶部，
    public E extractMax(){
        E ret=findMax();
        data.swap(0,data.getSize()-1); //第一个和最后一个元素互换
        data.removeLast(); //删除最后一个
        siftDown(0);
        return ret;
    }
    //下沉操作
    private void siftDown(int k){
        while (leftChild(k)<data.getSize()){
            //当有左孩子时，就证明该节点至少有子孩子
            //j是指代表将要交换的节点：可能是左，也可能是右节点
            int j=leftChild(k);// 在此轮循环中,data[k]和data[j]交换位置
            if(j+1<data.getSize()&&//说明有右孩子
                    data.get(j+1).compareTo(data.get(j))>0){  //这里比较左孩子j，右孩子j+1的大小，取比较大值
                j++;
            }
            // data[j] 是 leftChild 和 rightChild 中的最大值
            if(data.get(k).compareTo(data.get(j))>=0){
                break;
            }

            data.swap(k,j);
            k=j;
        }
    }

    //********************************************
    //8.替换元素
    public E replace(E e){
        E ret=findMax();
        data.set(0,e);
        siftDown(0);
        return ret;
    }

    //********************************************
    //9.Heapify的实现：一个构造函数
    public MaxHeap(E[] arr){
        data=new ArrayDynamic<E>(arr);
        for (int i =parent(arr.length-1);i>=0;i--){
            siftDown(i);
        }
    }
    //********************************************
    //测试
    public static void main(String[] args) {


        //测试一
//        int n=1000000;
//        MaxHeap<Integer> maxHeap=new MaxHeap<>();
//        Random random =new Random();
//        for (int i=0;i<n;i++){
//            maxHeap.add(random.nextInt(Integer.MAX_VALUE));
//        }
//
//        int[] arr=new int[n];
//        for (int i=0;i<n;i++){
//            arr[i]=maxHeap.extractMax();
//        }
//
//        for (int i=1;i<n;i++){
//            if(arr[i-1]<arr[i]){
//                throw new IllegalArgumentException("Error");
//            }
//        }
//        System.out.println("Test MaxHeap completed.");

        //测试二
        int n = 1000000;

        Random random = new Random();
        Integer[] testData = new Integer[n];
        for(int i = 0 ; i < n ; i ++)
            testData[i] = random.nextInt(Integer.MAX_VALUE);

        double time1 = testHeap(testData, false);
        System.out.println("Without heapify: " + time1 + " s");

        double time2 = testHeap(testData, true);
        System.out.println("With heapify: " + time2 + " s");
    }

    private static double testHeap(Integer[] testData, boolean isHeapify){

        long startTime = System.nanoTime();

        MaxHeap<Integer> maxHeap;
        if(isHeapify)
            maxHeap = new MaxHeap<>(testData);
        else{
            maxHeap = new MaxHeap<>();
            for(int num: testData)
                maxHeap.add(num);
        }

        int[] arr = new int[testData.length];
        for(int i = 0 ; i < testData.length ; i ++)
            arr[i] = maxHeap.extractMax();

        for(int i = 1 ; i < testData.length ; i ++)
            if(arr[i-1] < arr[i])
                throw new IllegalArgumentException("Error");
        System.out.println("Test MaxHeap completed.");

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }
}
