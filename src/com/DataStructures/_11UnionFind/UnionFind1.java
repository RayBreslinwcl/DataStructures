package com.DataStructures._11UnionFind;

/**
 * Created by Administrator on 2019/11/23.
 * 并查集实现1：基于数组实现
 */
public class UnionFind1 implements UF {


    private int[] id;

    public UnionFind1(int size){
        id=new int[size];

        for (int i=0;i<id.length;i++){
            id[i]=i;
        }
    }

    //判断两个元素是否属于同一个集合
    @Override
    public boolean isConnected(int p, int q) {
//        return false;
        return  find(p)==find(q);
    }

    //链接两个元素所在集合
    //解释：即p所在集合set1所有元素，与q所在集合set2所有元素，都合并为一个集合setmerge
    @Override
    public void unionElements(int p, int q) {

        int pId=find(p);
        int qId=find(q);

        if(pId==qId)
            return;

        for (int i=0;i<id.length;i++){
            if (id[i]==pId)
                id[i]=qId;
        }
    }

    @Override
    public int getSize() {
        return id.length;
//        return 0;
    }

    //查找元素p所对应的集合编号
    private int find(int p){
        if(p<0&&p>=id.length)
            throw  new IllegalArgumentException("p is out of bound");
        return id[p];
    }
}
