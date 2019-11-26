package com.DataStructures._14Hash;

import sun.reflect.generics.tree.Tree;

import java.util.TreeMap;

/**
 * Created by Administrator on 2019/11/26.
 * hashtable：哈希表
 */
public class HashTable <K ,V> {

    private final int[] capacity
            = {53, 97, 193, 389, 769, 1543, 3079, 6151, 12289, 24593,
            49157, 98317, 196613, 393241, 786433, 1572869, 3145739, 6291469,
            12582917, 25165843, 50331653, 100663319, 201326611, 402653189, 805306457, 1610612741};


    private static final int upperTol=10;
    private static final int lowerTol=2;
//    private static final int initCapacity=7; //初始容量
    private int capacityIndex=0; //初始容量


    private TreeMap<K,V>[] hashtable;
    private int M; //哈希表大小
    private int size; //哈希表存储数据多少


    public HashTable() {
        this.M = capacity[capacityIndex];
        size=0;
        hashtable=new TreeMap[M];
        for (int i = 0; i < M; i++) {
            hashtable[i]=new TreeMap<K, V>();
        }
    }

    //默认大小97
//    public HashTable(){
////        this(97);
//        this(initCapacity);
//    }


    //将key转换为整数索引
    private int hash(K key){
        return ((key.hashCode())&0x7ffffff)%M;
    }

    public int getSize(){
        return size;
    }

    //添加元素
    public void add(K key,V value){
        TreeMap<K,V> map=hashtable[hash(key)];
//        if(hashtable[hash(key)].containsKey(key)){
//            hashtable[hash(key)].put(key,value);
//        }else {
//            hashtable[hash(key)].put(key,value);
//            size++;
//        }
        if(map.containsKey(key)){
            map.put(key,value);
        }else {
            map.put(key,value);
            size++;

            if(size>=upperTol*M && capacityIndex+1<capacity.length){ //除法转换为乘法
                capacityIndex++;
//                resize(2*M); //超出界限，则扩容
                resize(capacity[capacityIndex]);
            }

        }
    }

    //删除
    public V remove(K key){
        TreeMap<K,V> map=hashtable[hash(key)];
        V returnvalue=null; //返回值
        if (map.containsKey(key)){
            returnvalue=map.remove(key);
            size--;

//            if (size< lowerTol*M && M/2>=initCapacity){ //除法转换为乘法
            if (size< lowerTol*M && capacityIndex-1>=0){ //除法转换为乘法
//                resize(M/2); //缩容
                capacityIndex--;
                resize(capacity[capacityIndex]);
            }
        }
        return returnvalue;
    }

    //辅助：修改容量
    private void resize(int newM){
        TreeMap<K,V>[] newHashTable=new TreeMap[newM];
        for (int i = 0; i < newM; i++) {
            newHashTable[i]=new TreeMap<K, V>();
        }

        int oldM=this.M;
        this.M=newM;
        for (int i = 0; i < oldM; i++) {
            TreeMap<K,V> map=hashtable[i];
            for (K key:map.keySet()){
                newHashTable[hash(key)].put(key,map.get(key));
            }
        }

        this.hashtable=newHashTable;
    }

    //修改
    public void set(K key,V value){
        TreeMap<K,V> map=hashtable[hash(key)];
        if(!map.containsKey(key)){
            throw new IllegalArgumentException(key+ "doesn't exist!");
        }
        map.put(key,value);
    }

    //查询：判断是否含有该key
    public boolean contains(K key){
        return hashtable[hash(key)].containsKey(key);
    }

    //查询：返回对应key的value
    public V get(K key){
        return hashtable[hash(key)].get(key);
    }
}
