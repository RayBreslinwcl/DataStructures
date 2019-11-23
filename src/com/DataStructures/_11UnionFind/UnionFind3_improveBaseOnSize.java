package com.DataStructures._11UnionFind;

/**
 * Created by Administrator on 2019/11/23.
 * 并查集
 * 优化实现：两个集合合并，添加判断条件，将节点个数大小小的，合并到节点个数大的sz，从而减少树深度
 */
public class UnionFind3_improveBaseOnSize implements UF {

    private  int[] parent;
    private  int[] sz; //sz[i] 表示以i为根的集合中元素个数

    public UnionFind3_improveBaseOnSize(int size){
        parent =new int [size];
        sz=new int[size];
        for (int i=0;i<size;i++){
            parent[i]=i;
            sz[i]=1;
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
    //更新优化
    @Override
    public void unionElements(int p, int q) {

        int pRoot=find(p);
        int qRoot=find(q);

        if(pRoot == qRoot)
            return;

        if(sz[pRoot]<sz[qRoot]){ //p的树节点树小于q的节点树，则p加到q
            parent[pRoot]=qRoot;
            sz[qRoot]+=sz[pRoot];
        }else {
            parent[qRoot]=pRoot;
            sz[pRoot]+=sz[qRoot];
        }


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
