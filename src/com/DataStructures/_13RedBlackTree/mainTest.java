package com.DataStructures._13RedBlackTree;

import com.DataStructures._12AVL.AVLTree;
import com.DataStructures._12AVL.BST;
import com.DataStructures._12AVL.FileOperation;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Administrator on 2019/11/23.
 * 性能测试
 */
public class mainTest {

    public static void main(String[] args) {


        System.out.println("Pride and Prejudice");

//        System.out.println(filename);
        String filename="src\\resources\\pride-and-prejudice.txt";
        ArrayList<String> words=new ArrayList<>();
        if(FileOperation.readFile(filename,words)){

            //增加排序条件:使words退化为链表
            Collections.sort(words);


            //BST tree验证================================================
            long startTime=System.nanoTime();
            //Test BST
            BST<String,Integer> bst=new BST<>();

            for (String word:words){

                if(bst.contains(word)){
                    bst.set(word,bst.get(word)+1);
                }else {
                    bst.add(word,1);
                }
            }

            //检查查询性能
            for (String word:words){
                bst.contains(word);
            }
//            System.out.println("Total different words:"+set.getSize());
            long endTime=System.nanoTime();

            double time=(endTime-startTime)/1000000000.0;
            System.out.println("BST : "+ time+" s");

            //AVL tree验证================================================
            startTime=System.nanoTime();
            //Test AVL
            AVLTree<String,Integer> avlTree=new AVLTree<>();

            for (String word:words){

                if(avlTree.contains(word)){
                    avlTree.set(word,avlTree.get(word)+1);
                }else {
                    avlTree.add(word,1);
                }
            }

            //检查查询性能
            for (String word:words){
                avlTree.contains(word);
            }
//            System.out.println("Total different words:"+set.getSize());
            endTime=System.nanoTime();

            time=(endTime-startTime)/1000000000.0;
            System.out.println("avlTree : "+ time+" s");




        }



//        return (endTime-startTime)/1000000000.0;

    }

}
