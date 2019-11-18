package com.DataStructures._01Arrays;

/**
 * Created by Administrator on 2018/12/10.
 */
public class ArrayDynamic<E> {
    private E[] data; //数组
    private int size; //数组中实际元素个数
//*****************************************************************************************
    //1.构造函数
    //构造函数，传入数组的容量capacity
    public ArrayDynamic(int capacity){
        data=(E[])new Object[capacity];
        size=0;
    }
    //无参数构造函数，默认数组的容量10
    public ArrayDynamic(){
        this(10);
    }

//*****************************************************************************************
    //2.获得基本信息操作
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
//*****************************************************************************************
    //3.添加元素操作（增）
    /**
     * 3.1向所有元素后添加一个新元素
     * @param e
     */
    public void addLast(E e){
        if (size==data.length){
            throw new IllegalArgumentException("AddLast failed. Array is full.");

        }
        data[size] = e;
        size ++;
    }
    /**
     * 3.2在所有元素前添加一个新元素
     * @param e
     */
    public void addFirst(E e){
        add(0,e);
    }

    /**
     * 3.3在index索引位置插入一个新元素
     * @param index 索引
     * @param e 元素
     */
    public void add(int index,E e){
        if(index<0||index>size){
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size.");
        }
        if(size==data.length){
            //当达到最大长度时候，实行扩容
            resize(2*data.length);
        }
        for (int i =size-1;i>=index;i--){
            data[i+1]=data[i];
        }
        data[index]=e;
        size++;
    }

    //将数组容量变为newCapacity大小
    private void resize(int newCapacity){
        E[] newData=(E[])new Object[newCapacity];
        for (int i =0;i<size;i++){
            newData[i]=data[i];
        }
        data=newData;
    }
//*****************************************************************************************

    //4.查询数据
    /**
     * 4.1获得指定位置元素
     * @param index
     * @return
     */
    public E get(int index){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        }
        return data[index];
    }

    /**
     * 4.2查找是否包含元素e
     * @param e
     * @return
     */
    public boolean contains(E e){
        for (int i =0;i<size;i++){
            if(data[i].equals(e)){
                return true;
            }
        }
        return false;
    }

    /**
     * 4.3查找包含元素所在索引，不包含则返回-1
     * @param e
     * @return
     */
    public int find(E e){
        for (int i =0;i<size;i++){
            if (data[i].equals(e)){
                return i;
            }
        }
        return -1;
    }
//*****************************************************************************************

    //5.修改
    /**
     * 5.1修改指定位置元素
     * @param index
     * @param e
     */
    public void set(int index,E e){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        }
        data[index]=e;
    }

//*****************************************************************************************
    //6.删除
    /**
     * 6.1 从数组中删除元素，返回删除元素
     * @param index
     * @return
     */
    public E remove(int index){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("Remove failed. Index is illegal.");
        }
        E ret=data[index];
        for (int i=index;i<size;i++){
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


    /**
     * 6.2 从数组中删除第一个元素，返回删除元素
     * @return
     */
    public E removeFirst(){
        return remove(0);
    }

    /**
     * 6.3 从数组中删除最后一个元素，返回删除元素
     * @return
     */
    public E removeLast(){
        return remove(size-1);
    }

    /**
     * 6.4 从数组中删除元素e
     * @param e
     */
    public void removeElement(E e){
        int index=find(e);
        if (index!=-1){
            remove(index);
        }
    }
    //*****************************************************************************************
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

}
