package com.DataStructures._02ArraysStackAndQueue;
//import java.util.Stack;

/**
 * Created by Administrator on 2018/12/13.
 */
public class _04Solution {

    public boolean isValid(String s){
        _02ArrayStack<Character> stack=new _02ArrayStack<>();

        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c=='('||c=='['||c=='{'){
                stack.push(c);
            }else {
                if(stack.isEmpty()){
                    return false;
                }

                char topChar=stack.pop();
                if(c==')'&&topChar!='(')
                    return false;
                if(c==']'&&topChar!='[')
                    return false;
                if(c=='}'&&topChar!='{')
                    return false;
            }

        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println((new _04Solution()).isValid("{}{]"));
        System.out.println((new _04Solution()).isValid("{}[]"));
        System.out.println((new _04Solution()).isValid("{}("));
    }
}
