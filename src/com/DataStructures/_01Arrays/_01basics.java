package com.DataStructures._01Arrays;

/**
 * Created by Administrator on 2018/11/18.
 */
public class _01basics {
    public static void main(String[] args) {
//        int[] arr=new int[20];
//        for (int i=0;i<arr.length;i++){
//            arr[i]=i;
//        }
//
//        int[] scores=new int[]{100,99,66};
//        for (int score:scores
//             ) {
//            System.out.println(score);
//        }
        _06ArrayFanxing<Integer> arr=new _06ArrayFanxing<>(20);
        for (int i=0;i<10;i++){
            arr.addLast(i);
        }
        System.out.println(arr);
    }
}
