package com.DataStructures._11UnionFind;

/**
 * Created by Administrator on 2019/11/23.
 * 并查集对用接口
 */
public interface UF {
    //查看两个元素是否属于同一个集合
    //id为p或者q
    boolean isConnected(int p,int q);

    //两个元素并在一起
    void unionElements(int p,int q);

    //获取整个容量
    int getSize();
}
