package com.DataStructures._02ArraysStackAndQueue;

import jdk.internal.org.objectweb.asm.commons.RemappingAnnotationAdapter;

import java.util.Queue;
import java.util.Random;

/**
 * Created by Administrator on 2018/12/12.
 */
public class Main {
    public static void main(String[] args) {
//        _02ArrayStack<Integer> stack=new _02ArrayStack<>();
//        for (int i=0;i<5;i++){
//            stack.push(i);
//            System.out.println(stack);
//        }
//        stack.pop();
//        System.out.println(stack);

        int opCount=200000;

        _05ArrayQueue<Integer> aq=new _05ArrayQueue<>();
        double time1=testQueue(aq,opCount);
        System.out.println("ArrayQueue,time:"+time1+" s");

        _06Loopqueue<Integer> lq=new _06Loopqueue<>();
        double time2=testQueue(lq,opCount);
        System.out.println("LoopQueue,time:"+time2+" s");

    }

    //返回时间，单位秒
    private static double testQueue(_05queue<Integer> q,int opCount){

        long startTime=System.nanoTime();
        Random random=new Random();
        for (int i=0;i<opCount;i++){
            q.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i=0;i<opCount;i++){
            q.dequeue();
        }

        long endTime=System.nanoTime();
        return (endTime-startTime)/1000000000.0;

    }
}
