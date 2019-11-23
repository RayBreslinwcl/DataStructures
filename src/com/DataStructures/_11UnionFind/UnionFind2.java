package com.DataStructures._11UnionFind;

/**
 * Created by Administrator on 2019/11/23.
 * 并查集
 * 第二种实现原理：每个集合元素指向上一个元素
 */
public class UnionFind2 implements UF {

    private  int[] parent;

    public UnionFind2 (int size){
        parent =new int [size];
        for (int i=0;i<size;i++){
            parent[i]=i;
        }
    }

    //查看元素p和q是否属于同一个集合
    //O（h）是否复杂度，h为树的高度
    @Override
    public boolean isConnected(int p, int q) {
//        return false;
        return find(p)==find(q);
    }

    //合并p和q所在两个集合
    //O（h）是否复杂度，h为树的高度
    @Override
    public void unionElements(int p, int q) {

        int pRoot=find(p);
        int qRoot=find(q);

        if(pRoot == qRoot)
            return;
        parent[pRoot]=qRoot;
    }

    @Override
    public int getSize() {
//        return 0;
        return parent.length;
    }

    //查找过程，查找元素p所对应的集合编号
    //O（h）复杂度，h为数的高度
    private int find(int p){
        if(p<0&&p>=parent.length)
            throw  new IllegalArgumentException("p is out of bound");

        while (p!=parent[p]){
            p=parent[p];
        }
        return p;
    }
}
