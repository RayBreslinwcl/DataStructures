package com.DataStructures._11UnionFind;

/**
 * Created by Administrator on 2019/11/23.
 * 并查集
 * 优化实现-基于rank优化：即基于树的高度（深度）的优化，因为节点数多的，有可能不深；而节点数少的，有可能很高。
 * 改进：基于4，添加路径压缩，压缩比较高，修改find函数
 */
public class UnionFind5_improveBaseOnCompress implements UF {

    private  int[] parent;
//    private  int[] sz; //sz[i] 表示以i为根的集合中元素个数

    private  int[] rank;  //rank[i] 表示以i为根的集合所表示的树的层数
    //rank[i] 当使用压缩后，rank不代表深度，而只是一个参考

    public UnionFind5_improveBaseOnCompress(int size){
        parent =new int [size];
        rank=new int[size];
        for (int i=0;i<size;i++){
            parent[i]=i;
            rank[i]=1;
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

        //根据两个元素所在树的高度rank不同，判断
        //rank低的合并到rank高的集合上面
        if(rank[pRoot]<rank[qRoot]){ //p的树高度小于q的高度，则p加到q
            parent[pRoot]=qRoot;
            //rank不需要维护，因为rank[q]不变，而p所在树变为q，即根节点也为qRoot，其深度也自动变为qRoot深度
        }else if(rank[pRoot]>rank[qRoot]){//q的树高度小于p的高度，则q加到p
            parent[qRoot]=pRoot;
        }else {
            parent[qRoot] =pRoot;
            rank[pRoot]+=1;
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
            parent[p]=parent[parent[p]]; //添加路径压缩
            p=parent[p];

        }
        return p;
    }
}
