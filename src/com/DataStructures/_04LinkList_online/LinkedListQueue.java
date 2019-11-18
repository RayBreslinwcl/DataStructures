package com.DataStructures._04LinkList_online;


public class LinkedListQueue<E> implements queue<E> {

    //节点数据结构Node
    private class Node{
        public E e;
        public Node next;

        public Node(E e, Node next){
            this.e = e;
            this.next = next;
        }

        public Node(E e){
            this(e, null);
        }

        public Node(){
            this(null, null);
        }

        @Override
        public String toString(){
            return e.toString();
        }
    }

    //***************************************************************************
    //1.基本信息
    private Node head, tail;
    private int size;
    //***************************************************************************
    //2.构造函数
    public LinkedListQueue(){
        head = null;
        tail = null;
        size = 0;
    }
    //***************************************************************************
    //3.获得基本信息
    @Override
    public int getSize(){
        return size;
    }

    @Override
    public boolean isEmpty(){
        return size == 0;
    }
    //***************************************************************************
    //4.入队：在链表尾部入队
    @Override
    public void enqueue(E e){
        if (tail==null){
            tail=new Node(e);
            head=tail;
        }else {
            tail.next=new Node(e);
            tail=tail.next;
        }
        size++;
    }
    //***************************************************************************
    //5.出队：在链表首部出队
    @Override
    public E dequeue(){

        if (isEmpty())
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
        Node retNode=head;
        head=head.next;
        retNode.next=null;
        if (head==null)
            tail=null;
        size--;
        return retNode.e;
    }
    //***************************************************************************
    //6.获得开始元素
    @Override
    public E getFront(){
        if(isEmpty())
            throw new IllegalArgumentException("Queue is empty.");
        return head.e;
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("Queue: front ");

        Node cur = head;
        while(cur != null) {
            res.append(cur + "->");
            cur = cur.next;
        }
        res.append("NULL tail");
        return res.toString();
    }

    public static void main(String[] args){

        LinkedListQueue<Integer> queue = new LinkedListQueue<>();
        for(int i = 0 ; i < 10 ; i ++){
            queue.enqueue(i);
            System.out.println(queue);

            if(i % 3 == 2){
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}
