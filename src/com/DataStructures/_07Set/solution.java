package com.DataStructures._07Set;

import java.util.TreeSet;

/**
 * Created by Administrator on 2018/12/17.
 */
public class solution {
    public int uniqueMorseRepresentations(String[] words){

        String[] codes = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

        TreeSet<String> set=new TreeSet<>();
        for (String word:words){
            StringBuilder res=new StringBuilder();
            for (int i=0;i<word.length();i++){
                res.append(codes[word.charAt(i)-'a']);
            }
            set.add(res.toString());
        }

        return set.size();

    }
}
