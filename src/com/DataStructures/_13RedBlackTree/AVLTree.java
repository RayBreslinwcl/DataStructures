package com.DataStructures._13RedBlackTree;

import java.util.ArrayList;

/**
 * Created by Administrator on 2019/11/23.
 */
public class AVLTree <K extends Comparable<K>, V> {

    private class Node{
        public K key;
        public V value;
        public Node left, right;
        public int height; //每个节点的高度值

        public Node(K key, V value){
            this.key = key;
            this.value = value;
            left = null;
            right = null;

            height=1;
        }
    }

    private Node root;
    private int size;

    public AVLTree(){
        root = null;
        size = 0;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    //=======================辅助函数 start=================================
    //返回当前节点node的高度
    private int getHeight(Node node){
        if (node==null){
            return 0;
        }
        return node.height;
    }

    //计算每个节点的平衡因子
    //平衡因子>=2或则<=-2时，则有问题
    private int getBalanceFactor(Node node){
        if(node==null){
            return 0;
        }
        return  getHeight(node.left)-getHeight(node.right);
    }


    //判断当前树是否时二分搜索树：通过中序遍历，由小到打
    //二分搜索树：所有节点满足，左子节点小于根节点，右子节点大于根节点
    public boolean isBST(){
        ArrayList<K> keys=new ArrayList<K>();
        inOrder(root,keys);

        for (int i = 1; i < keys.size(); i++) {
            if(keys.get(i-1).compareTo(keys.get(i))>0){
                return false;
            }
        }
        return true;
    }

    private void inOrder(Node node,ArrayList<K> keys){
        if (node==null){
            return;
        }

        inOrder(node.left,keys);
        keys.add(node.key);
        inOrder(node.right,keys );
    }

    //判断该二叉树，是否是一个平衡二叉树
    public boolean isBalanced(){
        return isBalanced(root);
    }

    //判断以Node为根的二叉树是否是一个平衡二叉树，使用递归算法
    public boolean isBalanced(Node node){

        if(node==null)
            return true;

        int balanceFactor=getBalanceFactor(node);
        if(Math.abs(balanceFactor)>1){
            return false;
        }
        return isBalanced(node.left) && isBalanced(node.right);
    }

    //=======================辅助函数 end=================================

    // 向二分搜索树中添加新的元素(key, value)
    public void add(K key, V value){
        root = add(root, key, value);
    }

    // 向以node为根的二分搜索树中插入元素(key, value)，递归算法
    // 返回插入新节点后二分搜索树的根
    private Node add(Node node, K key, V value){

        if(node == null){
            size ++;
            return new Node(key, value);
        }

        if(key.compareTo(node.key) < 0)
            node.left = add(node.left, key, value);
        else if(key.compareTo(node.key) > 0)
            node.right = add(node.right, key, value);
        else // key.compareTo(node.key) == 0
            node.value = value;

        //1.更新height
        node.height=1+Math.max(getHeight(node.left),getHeight(node.right));

        //2.计算平衡因子
        int balanceFactor=getBalanceFactor(node);
//        if(Math.abs(balanceFactor)>1){
//            System.out.println("unbalanced : "+balanceFactor);
//        }

        //3.如果平衡因子大于1，则维护平衡性
        //情况1【LL】：左侧大于右侧，而且左子树的平衡因子大于等于0，进行右旋转
        if(balanceFactor>1&&getBalanceFactor(node.left)>=0){
            return rightRotate(node);
        }
        //情况2【RR】：右侧大于左侧，而且右子树平衡因子小于等于0，即向右倾斜，进行左旋转
        if (balanceFactor<-1&&getBalanceFactor(node.right)<=0){
            return leftRotate(node);
        }
        //情况3【LR】
        if(balanceFactor>1&&getBalanceFactor(node.left)<0){
            node.left=leftRotate(node.left);
            return rightRotate(node);
        }
        //情况4【RL】
        if (balanceFactor<-1&&getBalanceFactor(node.right)>0){
            node.right=rightRotate(node.right);
            return leftRotate(node);
        }
        return node;
    }

    //右旋转
    // 对节点y进行向右旋转操作，返回旋转后新的根节点x
    //        y                              x
    //       / \                           /   \
    //      x   T4     向右旋转 (y)        z     y
    //     / \       - - - - - - - ->    / \   / \
    //    z   T3                       T1  T2 T3 T4
    //   / \
    // T1   T2
    private Node rightRotate(Node y){

        Node x=y.left;

        Node T3=x.right;
        //向右旋转
        x.right=y;
        y.left=T3;

        //更新x，y的height值
        y.height=Math.max(getHeight(y.left),getHeight(y.right))+1;
        x.height=Math.max(getHeight(x.left),getHeight(x.right))+1;

        return x;
    }

    //左旋转
    // 对节点y进行向左旋转操作，返回旋转后新的根节点x
    //    y                             x
    //  /  \                          /   \
    // T1   x      向左旋转 (y)       y     z
    //     / \   - - - - - - - ->   / \   / \
    //   T2  z                     T1 T2 T3 T4
    //      / \
    //     T3 T4
    private Node leftRotate(Node y){

        Node x=y.right;
        Node T2=x.left;

        //向左旋转
        x.left=y;
        y.right=T2;

        //更新height
        y.height=Math.max(getHeight(y.left),getHeight(y.right))+1;
        x.height=Math.max(getHeight(x.left),getHeight(x.right))+1;

        return x;
    }

    // 返回以node为根节点的二分搜索树中，key所在的节点
    private Node getNode(Node node, K key){

        if(node == null)
            return null;

        if(key.equals(node.key))
            return node;
        else if(key.compareTo(node.key) < 0)
            return getNode(node.left, key);
        else // if(key.compareTo(node.key) > 0)
            return getNode(node.right, key);
    }

    public boolean contains(K key){
        return getNode(root, key) != null;
    }

    public V get(K key){

        Node node = getNode(root, key);
        return node == null ? null : node.value;
    }

    public void set(K key, V newValue){
        Node node = getNode(root, key);
        if(node == null)
            throw new IllegalArgumentException(key + " doesn't exist!");

        node.value = newValue;
    }

    // 返回以node为根的二分搜索树的最小值所在的节点
    private Node minimum(Node node){
        if(node.left == null)
            return node;
        return minimum(node.left);
    }

    // 删除掉以node为根的二分搜索树中的最小节点
    // 返回删除节点后新的二分搜索树的根
    private Node removeMin(Node node){

        if(node.left == null){
            Node rightNode = node.right;
            node.right = null;
            size --;
            return rightNode;
        }

        node.left = removeMin(node.left);
        return node;
    }

    // 从二分搜索树中删除键为key的节点
    public V remove(K key){

        Node node = getNode(root, key);
        if(node != null){
            root = remove(root, key);
            return node.value;
        }
        return null;
    }

    private Node remove(Node node, K key){

        if( node == null )
            return null;

        //最终要返回的node
        Node retNode;

        if( key.compareTo(node.key) < 0 ){
            node.left = remove(node.left , key);
//            return node;
            retNode=node;
        }
        else if(key.compareTo(node.key) > 0 ){
            node.right = remove(node.right, key);
//            return node;
            retNode=node;
        }
        else{   // key.compareTo(node.key) == 0


            if(node.left == null){   // 待删除节点左子树为空的情况
                Node rightNode = node.right;
                node.right = null;
                size --;
//                return rightNode;
                retNode=rightNode;
            }else  if(node.right == null){  // 待删除节点右子树为空的情况
                Node leftNode = node.left;
                node.left = null;
                size --;
//                return leftNode;
                retNode=leftNode;
            }else {     // 待删除节点左右子树均不为空的情况

                // 找到比待删除节点大的最小节点, 即待删除节点右子树的最小节点
                // 用这个节点顶替待删除节点的位置
                Node successor = minimum(node.right);
//            successor.right = removeMin(node.right);  //可能会引起删除值
                successor.right=remove(node.right,successor.key);//服用remove的调整方法
                successor.left = node.left;
                node.left = node.right = null;
//            return successor;
                retNode=successor;
            }

        }

//        当retNode为空的时候，则直接返回
        if (retNode==null){
            return null;
        }

        //1.更新height
        retNode.height=1+Math.max(getHeight(retNode.left),getHeight(retNode.right));

        //2.计算平衡因子
        int balanceFactor=getBalanceFactor(retNode);
//        if(Math.abs(balanceFactor)>1){
//            System.out.println("unbalanced : "+balanceFactor);
//        }

        //3.如果平衡因子大于1，则维护平衡性
        //情况1【LL】：左侧大于右侧，而且左子树的平衡因子大于等于0，进行右旋转
        if(balanceFactor>1&&getBalanceFactor(retNode.left)>=0){
            return rightRotate(retNode);
        }
        //情况2【RR】：右侧大于左侧，而且右子树平衡因子小于等于0，即向右倾斜，进行左旋转
        if (balanceFactor<-1&&getBalanceFactor(retNode.right)<=0){
            return leftRotate(retNode);
        }
        //情况3【LR】
        if(balanceFactor>1&&getBalanceFactor(retNode.left)<0){
            retNode.left=leftRotate(retNode.left);
            return rightRotate(retNode);
        }
        //情况4【RL】
        if (balanceFactor<-1&&getBalanceFactor(retNode.right)>0){
            node.right=rightRotate(retNode.right);
            return leftRotate(retNode);
        }
        return retNode;



    }

    public static void main(String[] args){

        System.out.println("Pride and Prejudice");

        ArrayList<String> words = new ArrayList<>();
        if(FileOperation.readFile("src/resources/pride-and-prejudice.txt", words)) {
            System.out.println("Total words: " + words.size());

            AVLTree<String, Integer> map = new AVLTree<>();
            for (String word : words) {
                if (map.contains(word))
                    map.set(word, map.get(word) + 1);
                else
                    map.add(word, 1);
            }

            System.out.println("Total different words: " + map.getSize());
            System.out.println("Frequency of PRIDE: " + map.get("pride"));
            System.out.println("Frequency of PREJUDICE: " + map.get("prejudice"));

            System.out.println("is BST : "+map.isBST());
            System.out.println("is Balance : "+ map.isBalanced());

            for (String word : words) {
                map.remove(word);
                if(!map.isBST()||!map.isBalanced()){
//                    System.out.println("");
                    throw new RuntimeException("Error: 非BST，或者非平衡树");
                }
            }
        }

        System.out.println();
    }
}
