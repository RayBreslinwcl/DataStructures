package com.DataStructures._08Heap;

/**
 * Created by Administrator on 2018/12/10.
 */
public class ArrayDynamic<E> {
    private E[] data; //数组
    private int size; //数组中实际元素个数

    //构造函数，传入数组的容量capacity
    public ArrayDynamic(int capacity){
        data=(E[])new Object[capacity];
        size=0;
    }

    //无参数构造函数，默认数组的容量10
    public ArrayDynamic(){
        this(10);
    }

    //传入数组构造函数
    public ArrayDynamic(E[] arr)
    {
        data=(E[])new Object[arr.length];
        for (int i=0;i<arr.length;i++){
            data[i]=arr[i];
        }
        size=arr.length;

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
    public void addLast(E e){
//        if (size==data.length){
//            throw new IllegalArgumentException("AddLast failed. Array is full.");
//
//        }
//        data[size] = e;
//        size ++;
        add(size,e);
    }
    //在所有元素前添加一个新元素
    public void addFirst(E e){
        add(0,e);
    }
    //在index索引位置插入一个新元素
    public void add(int index,E e){

        if(index<0||index>size){
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size.");
        }
        if(size==data.length){
//            throw new IllegalArgumentException("AddLast failed. Array is full.");
            //当达到最大长度时候，实行扩容
            resize(2*data.length);
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

    public E get(int index){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        }
        return data[index];
    }

    public void set(int index,E e){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        }
        data[index]=e;
    }

    //查找是否包含元素e
    public boolean contains(E e){
        for (int i =0;i<size;i++){
            if(data[i].equals(e)){
                return true;
            }
        }
        return false;
    }
    //查找包含元素所在索引，不包含则返回-1
    public int find(E e){
        for (int i =0;i<size;i++){
            if (data[i].equals(e)){
                return i;
            }
        }
        return -1;
    }

    //从数组中删除元素，返回删除元素
    public E remove(int index){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("Remove failed. Index is illegal.");
        }
        E ret=data[index];
        for (int i=index;i<size-1;i++){
            data[i]=data[i+1];
        }
        size--;
        data[size]=null;

        if(size == data.length / 4 && data.length / 2 != 0)
        {
            resize(data.length/2);
        }
        return ret;
    }

    //从数组中删除第一个元素，返回删除元素
    public E removeFirst(){
        return remove(0);
    }
    //从数组中删除最后一个元素，返回删除元素
    public E removeLast(){
        return remove(size-1);
    }

    //从数组中删除元素e
    public void removeElement(E e){
        int index=find(e);
        if (index!=-1){
            remove(index);
        }
    }
    //将数组容量变为newCapacity大小
    private void resize(int newCapacity){
        E[] newData=(E[])new Object[newCapacity];
        for (int i =0;i<size;i++){
            newData[i]=data[i];
        }
        data=newData;
    }


    /**
     * 交换元素位置
     * @param i
     * @param j
     */
    public void swap(int i,int j){
        if(i<0||i>=size || j<0 ||j >=size){
            throw new IllegalArgumentException("Index is illegal");
        }
        E t=data[i];
        data[i]=data[j];
        data[j]=t;
    }

}
