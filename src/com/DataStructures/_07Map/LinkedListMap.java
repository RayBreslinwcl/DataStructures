package com.DataStructures._07Map;

import com.DataStructures._07Set.FileOperation;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/12/17.
 * LinkedList重写
 */
public class LinkedListMap<K,V> implements Map<K,V> {
    //1.基本存储结构
    private class Node{
        public K key;
        public V value;
        public Node next;

        public Node(K key,V value,Node next){
            this.key=key;
            this.value=value;
            this.next=next;
        }
        public Node(K key,V value){
            this(key,value,null);
        }
        public Node(){
            this(null,null,null);
        }
        @Override
        public String toString(){
            return key.toString() + " : " + value.toString();
        }
    }

    //2.存储基本信息
    private Node dummyHead;
    private int size;

    //3.构造函数
    public LinkedListMap(){
        dummyHead=new Node();
        size=0;
    }

    //4.获得基本信息
    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    //****************************************
    private Node getNode(K key){
        Node cur=dummyHead.next;
        while (cur!=null){
            if(cur.key.equals(key)){
                return cur;
            }
            cur=cur.next;
        }
        return null;
    }
    //****************************************
    //5.查询
    /**
     * 5.1 判断是否包含该键
     * @param key
     * @return
     */
    @Override
    public boolean contains(K key) {

        return getNode(key)!=null;
    }

    /**
     * 5.2 返回键对应值
     * @param key
     * @return
     */
    @Override
    public V get(K key) {
        Node node=getNode(key);
        return node==null?null:node.value;
    }
    //****************************************
    //6.增加
    @Override
    public void add(K key, V value) {
        Node node=getNode(key);
        if(node==null){
            dummyHead.next=new Node(key,value,dummyHead.next);
            size++;
        }else {
            node.value=value;
        }

    }
    //****************************************
    //7.修改
    @Override
    public void set(K key, V value) {
        Node node=getNode(key);
        if(node==null){
            throw new IllegalArgumentException(key + " doesn't exist!");
        }
        node.value=value;
    }
    //****************************************
    //8.删除
    @Override
    public V remove(K key) {
        Node prev=dummyHead;
        while (prev.next!=null){
            if(prev.next.key.equals(key)){
                break;
            }
            prev=prev.next;
        }
        if(prev.next!=null){
            Node delNode=prev.next;
            prev.next=delNode.next;
            delNode.next=null;
            size--;
            return delNode.value;
        }
        return null;
    }


    public static void main(String[] args) {
        System.out.println("Pride and Prejudice");

        ArrayList<String> words = new ArrayList<>();
        if(FileOperation.readFile("E:\\Tools\\WorkspaceforMyeclipse\\DataStructures\\src\\com\\DataStructures\\_07SetAndMap\\pride-and-prejudice.txt", words)){
            System.out.println("Total words: " + words.size());

            LinkedListMap<String,Integer> map=new LinkedListMap<>();
            for (String word:words){
                if(map.contains(word)){
                    map.set(word,map.get(word)+1);
                }else {
                    map.add(word,1);
                }
            }

            System.out.println("Total different words:"+map.getSize());
        }

    }


}
