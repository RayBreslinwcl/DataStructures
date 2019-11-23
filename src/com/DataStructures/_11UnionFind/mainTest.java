package com.DataStructures._11UnionFind;

import java.util.Random;

/**
 * Created by Administrator on 2019/11/23.
 */
public class mainTest {

    private static double testUF(UF uf,int m){
        int size=uf.getSize();
        Random random=new Random();
        long startTime=System.nanoTime();

        //合并
        for (int i = 0; i < m; i++) {
            int a=random.nextInt(size);
            int b=random.nextInt(size);
            uf.unionElements(a,b);
        }
        //查询是否在同一集合
        for (int i=0;i<m;i++){
            int a=random.nextInt(size);
            int b=random.nextInt(size);
            uf.isConnected(a,b);
        }

        long endTime=System.nanoTime();
        return (endTime-startTime)/1000000000.0;
    }

    public static void main(String[] args) {

        int size=10000000;
        int m=10000000;

//        UnionFind1 uf1=new UnionFind1(size);
//        System.out.println("UnionFind1 : "+ testUF(uf1,m)+" s");
//
//        UnionFind2 uf2=new UnionFind2(size);
//        System.out.println("UnionFind2 : "+ testUF(uf2,m)+" s");

        UnionFind3_improveBaseOnSize uf3=new UnionFind3_improveBaseOnSize(size);
        System.out.println("UnionFind3_improveBaseOnSize : "+ testUF(uf3,m)+" s");


        UnionFind4_improveBaseOnRank uf4=new UnionFind4_improveBaseOnRank(size);
        System.out.println("UnionFind4_improveBaseOnRank : "+ testUF(uf4,m)+" s");

        //添加路径压缩
        UnionFind5_improveBaseOnCompress uf5=new UnionFind5_improveBaseOnCompress(size);
        System.out.println("UnionFind5_improveBaseOnCompress : "+ testUF(uf5,m)+" s");



    }
}
