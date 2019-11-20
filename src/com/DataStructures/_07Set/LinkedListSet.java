package com.DataStructures._07Set;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/12/17.
 * 基于链表的集合
 */
public class LinkedListSet<E> implements Set<E> {
    //1.基本结构
    private LinkedDummyHeadList<E> list;
    //************************************************************
    //2.构造函数
    public LinkedListSet(){
        list=new LinkedDummyHeadList<E>();
    }
    //************************************************************
    //3.获得基本信息
    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }
    //************************************************************
    //4.增加元素
    @Override
    public void add(E e) {
        if(!list.contains(e)){
            list.addFirst(e);
        }
    }
    //************************************************************
    //5.删除元素
    @Override
    public void remove(E e) {
        list.removeElement(e);
    }
    //************************************************************
    //6.查询元素
    @Override
    public boolean contains(E e) {
        return list.contains(e);
    }


    public static void main(String[] args) {

        System.out.println("Pride and Prejudice");
        ArrayList<String> words1=new ArrayList<>();
        FileOperation.readFile("E:\\Tools\\WorkspaceforMyeclipse\\DataStructures\\src\\com\\DataStructures\\_07SetAndMap\\pride-and-prejudice.txt",words1);
        System.out.println("total words:"+words1.size());

        LinkedListSet<String> set1=new LinkedListSet<>();
        for(String word:words1){
            set1.add(word);
        }
        System.out.println("Total different words:"+ set1.getSize());
    }
}
