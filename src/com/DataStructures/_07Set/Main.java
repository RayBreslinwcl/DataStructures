package com.DataStructures._07Set;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/12/17.
 */
public class Main {
    private static double testSet(Set<String> set,String filename){

        long startTime=System.nanoTime();

        System.out.println(filename);
        ArrayList<String> words=new ArrayList<>();
        if(FileOperation.readFile(filename,words)){
            System.out.println("Total words:"+ words.size());
            for (String word:words){
                set.add(word);
            }
            System.out.println("Total different words:"+set.getSize());
        }
        long endTime=System.nanoTime();
        return (endTime-startTime)/1000000000.0;
    }

    public static void main(String[] args) {
        String filename="E:\\Tools\\WorkspaceforMyeclipse\\DataStructures\\src\\com\\DataStructures\\_07SetAndMap\\pride-and-prejudice.txt";

        BSTSet<String> bstSet=new BSTSet<>();
        double time1=testSet(bstSet,filename);
        System.out.println("BST Set:"+time1+" s");

        System.out.println();

        LinkedListSet<String> linkedlistSet=new LinkedListSet<>();
        double time2=testSet(linkedlistSet,filename);
        System.out.println("Linked List Set:"+time2+" s");


    }
}
