package com.DataStructures._06BinarySearchTree;

/**
 * Created by Administrator on 2019/11/19.
 */
public class mainTest {
    public static void main(String[] args) {

        BSTimprove<Integer> bsTimprove=new BSTimprove<>();
        int[] nums={534,234,23,453,23,4};
        for (int num:nums){
            bsTimprove.add(num);
        }

        //前序遍历
        bsTimprove.preOrder();
        System.out.println();
        System.out.println(bsTimprove);
    }
}
