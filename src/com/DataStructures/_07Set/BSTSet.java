package com.DataStructures._07Set;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/12/17.
 * 基于二分搜索树的集合类
 */
public class BSTSet<E extends Comparable<E>> implements Set<E> {

    //1.基本结构
    private BSTimprove<E> bst;

    //2.结合构造函数
    public BSTSet(){
        bst=new BSTimprove<E>();
    }

    //3.基本信息
    @Override
    public int getSize() {
        return bst.size();
    }

    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }

    //4.增加数据
    @Override
    public void add(E e) {
        bst.add(e);
    }

    //5.删除数据
    @Override
    public void remove(E e) {
        bst.remove(e);
    }

    //6.查询数据
    @Override
    public boolean contains(E e) {
//        return false;
        return bst.contains(e);
    }



    public static void main(String[] args) {

        System.out.println("Pride and Prejudice");
        ArrayList<String> words1=new ArrayList<>();
        FileOperation.readFile("E:\\Tools\\WorkspaceforMyeclipse\\DataStructures\\src\\com\\DataStructures\\_07SetAndMap\\pride-and-prejudice.txt",words1);
        System.out.println("total words:"+words1.size());

        BSTSet<String> set1=new BSTSet<>();
        for(String word:words1){
            set1.add(word);
        }
        System.out.println("Total different words:"+ set1.getSize());

    }
}
