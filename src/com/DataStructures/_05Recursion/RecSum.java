package com.DataStructures._05Recursion;

/**
 * Created by Administrator on 2019/11/19.
 * 递归实现加和
 */
public class RecSum {
    /**
     * 0.客户端函数
     * @param array
     * @return
     */
    public static int sum(int[] array){

        return sum_exe(array,0);
    }

    /**
     * 0-1.计算array[l,n)这个区间内的所有数字和
     * @param array
     * @param l
     * @return
     */
    private static int sum_exe(int[] array ,int l){
        //第一步：求解最基本的问题
        if (l==array.length)
            return 0;
        //第二步：把原始问题转化为更小的问题
        return array[l]+sum_exe(array,l+1);
    }

    public static void main(String[] args) {
        int[] nums={1,2,4,5,76,45,34};
        System.out.println(sum(nums));
    }
}
