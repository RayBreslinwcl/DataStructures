package com.DataStructures._06BinarySearchTree;

import java.util.*;

/**
 * Created by Administrator on 2018/12/16.
 */
public class BSTimprove<E extends Comparable<E>> {

    //节点类
    private  class Node{
        public E e;
        public Node left,right;

        public Node(E e){
            this.e=e;
            left=null;
            right=null;
        }
    }

    //根节点信息
    private Node root;
    private int size;

    public BSTimprove(){
        root=null;
        size=0;
    }

    //***************************************************************
    //1.获得基本信息
    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size==0;
    }

    //***************************************************************
    //2.添加新元素

    /**
     * 2.1向二分搜索树中添加新元素
     * @param e
     */
    public  void add(E e){
//        if(root==null){
//            root=new Node(e);
//            size++;
//        }else {
//            add(root,e);
//        }
        root=add(root,e);
    }

    /**
     * 2.2向以node为根的二分搜索树中插入元素e，递归算法
     * 返回插入新节点后二分搜索树的根
     * @param node
     * @param e
     * @return
     */
    private Node add(Node node,E e){

        if(node==null){
            size++;
            return new Node(e);
        }

        if(e.compareTo(node.e)<0){
            node.left= add(node.left,e);
        }else if(e.compareTo(node.e)>0){
            node.right=add(node.right,e);
        }
        return node;

    }

    //***************************************************************
    //3.查询

    /**
     * 3.1查询是否包含某个元素
     * @param e
     * @return
     */
    public boolean contains(E e){
        return contains(root,e);
    }

    private boolean contains(Node node,E e){
        if(node==null)
            return false;


        if(e.compareTo(node.e)==0){
            return true;
        }else if(e.compareTo(node.e)<0){
            return contains(node.left,e);
        }else{
            return contains(node.right,e);
        }
    }


    /**
     * 3.2 二分搜索树的前序遍历
     */
    public void preOrder(){
        preOrder(root);
    }
    // 前序遍历以node为根的二分搜索树, 递归算法
    private void preOrder(Node node){
        if(node==null){
            return;
        }

        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }


    /**
     * 3.3 非递归前序遍历
     */
    public void preOrderNR(){
        if (root==null){
            return;
        }

        Stack<Node> stack=new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            Node cur=stack.pop();
            System.out.println(cur.e);

            if(cur.right!=null){
                stack.push(cur.right);
            }
            if(cur.left!=null){
                stack.push(cur.left);
            }
        }
    }

    /**
     * 3.4 二分搜索树的层序遍历
     */
    public void levelOrder(){
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()){
            Node cur=q.remove();
            System.out.println(cur.e);

            if(cur.left!=null){
                q.add(cur.left);
            }
            if(cur.right!=null){
                q.add(cur.right);
            }
        }
    }


    /**
     * 3.5 二分搜索树的中序遍历
     */
    public void inOrder(){
        inOrder(root);
    }
    // 中序遍历以node为根的二分搜索树, 递归算法
    private void inOrder(Node node){
        if(node==null)
            return;

        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    /**
     * 3.6 后序遍历
     */
    public void postOrder(){
        postOrder(root);
    }


    private void postOrder(Node node){
        if(node==null)
            return;

        inOrder(node.left);
        inOrder(node.right);
        System.out.println(node.e);
    }
    //*****************************************************
    //辅助函数:
    @Override
    public String toString(){
        StringBuilder res=new StringBuilder();
        generateBSTString(root,0,res);
        return res.toString();
    }

    private void generateBSTString(Node node,int depth,StringBuilder res){

        if(node==null){
            res.append(generateDepthString(depth)+"null\n");
            return;
        }

        res.append(generateDepthString(depth)+node.e+"\n");

        generateBSTString(node.left,depth+1,res);
        generateBSTString(node.right,depth+1,res);
    }

    private String generateDepthString(int depth){
        StringBuilder res=new StringBuilder();
        for (int i=0;i<depth;i++){
            res.append("== ");
        }
        return res.toString();
    }
    //*****************************************************
    //4.查询最大和最小元素

    /**
     * 4.1 寻找二分搜索树的最小元素
     * @return
     */
    public E minimum(){
        if(size==0){
            throw new IllegalArgumentException("BST is empty");
        }
        return minimum(root).e;
    }

    //返回以node为根的二分搜索树的最小值所在的节点
    private Node minimum(Node node){
        if(node.left==null){
            return node;
        }
        return minimum(node.left);
    }

    /**
     * 4.2 寻找二分搜索树的最大元素
     * @return
     */
    public E maximum(){
        if(size==0){
            throw new IllegalArgumentException("BST is empty");
        }
        return maximum(root).e;
    }

    //返回以node为根的二分搜索树的最大值所在的节点
    private Node maximum(Node node){
        if(node.right==null){
            return node;
        }
        return maximum(node.right);
    }
    //*****************************************************
    //5.删除

    /**
     * 5.1 从二分搜索树中删除最小值所在节点, 返回最小值
     * @return
     */
    public E removeMin(){
        E ret=minimum();
        root =removeMin(root);
        return ret;
    }
    // 删除掉以node为根的二分搜索树中的最小节点
    // 返回删除节点后新的二分搜索树的根
    private Node removeMin(Node node){
        if(node.left==null){
            Node rightNode=node.right;
            node.right=null;
            size--;
            return rightNode;
        }

        node.left=removeMin(node.left);
        return node;
    }

    /**
     * 5.2 从二分搜索树中删除最大值所在节点, 返回最小值
     * @return
     */
    public E removeMax(){
        E ret=minimum();
        root =removeMin(root);
        return ret;
    }
    // 删除掉以node为根的二分搜索树中的最大节点
    // 返回删除节点后新的二分搜索树的根
    private Node removeMax(Node node){
        if(node.right==null){
            Node rightNode=node.left;
            node.left=null;
            size--;
            return rightNode;
        }

        node.right=removeMin(node.right);
        return node;
    }
    /**
     * 5.3 从二分搜索树中删除元素为e的节点
     * @param e
     */
    public void remove(E e){
        root=remove(root,e);
    }
    // 删除掉以node为根的二分搜索树中值为e的节点, 递归算法
    // 返回删除节点后新的二分搜索树的根
    private Node remove(Node node,E e){
        if(node==null){
            return null;
        }

        if(e.compareTo(node.e)<0){
            node.left=remove(node.left,e);
            return  node;
        }else if(e.compareTo(node.e)>0){
            node.right=remove(node.right,e);
            return node;
        }else { // e.compareTo(node.e) == 0
            //待删除节点左子树为空
            if(node.left==null){
                Node rightNode=node.right;
                node.right=null;
                size--;
                return rightNode;
            }

            // 待删除节点右子树为空的情况
            if(node.right==null){
                Node leftNode=node.left;
                node.left=null;
                size--;
                return leftNode;
            }

            // 待删除节点左右子树均不为空的情况
            // 找到比待删除节点大的最小节点, 即待删除节点右子树的最小节点
            // 用这个节点顶替待删除节点的位置
            Node successor=minimum(node.right);
            successor.right=removeMin(node.right);
            successor.left=node.left;
            node.left=null;
            node.right=null;
            return successor;

        }


    }

    //*****************************************************


    //*****************************************************

    public static void main(String[] args) {
//        BSTimprove<Integer> bst=new BSTimprove<>();
//        int[] nums={5,4,23,4,23,534,3,34,32,189};
//        for (int num:nums){
//            bst.add(num);
//        }
//        bst.preOrder();
//        System.out.println();
//
//        //遍历打印
////        System.out.println(bst);
//
//        bst.inOrder();
//        System.out.println();
//
//        bst.postOrder();
//        System.out.println();
//
//        bst.levelOrder();

        //test2
        BSTimprove<Integer> bst=new BSTimprove<>();
        Random random=new Random();

        int n=1000;
        for (int i =0;i<n;i++){
            bst.add(random.nextInt(10000));
        }
        ArrayList<Integer> nums=new ArrayList<>();
        while (!bst.isEmpty()){
            nums.add(bst.removeMin());
        }
        System.out.println(nums);
    }
}
