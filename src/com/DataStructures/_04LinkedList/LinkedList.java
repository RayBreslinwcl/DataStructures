package com.DataStructures._04LinkedList;

/**
 * Created by Administrator on 2018/12/14.
 */
public class LinkedList<E> {
    private class Node{
        public E e;
        public Node next;

        public Node(E e,Node next){
            this.e=e;
            this.next=next;
        }

        public Node(E e){
            this(e,null);
        }

        public  Node(){
            this(null,null);
        }

        @Override
        public String toString(){
            return e.toString();
        }
    }

    private Node head;
    private int size;

    public LinkedList(){
        head = null;
        size=0;
    }

    // 获取链表中的元素个数
    public int getSize(){
        return size;
    }

    // 返回链表是否为空
    public boolean isEmpty(){
        return size==0;
    }

    // 在链表头添加新的元素e
    public void addFirst(E e){
//        Node node=new Node(e);
//        node.next=head;
//        head=node;

        head=new Node(e,head);
        size++;
    }

    // 在链表的index(0-based)位置添加新的元素e
    public void add(int index,E e){
        if(index < 0 || index > size)
            throw new IllegalArgumentException("Add failed. Illegal index.");

        if(index==0){
            addFirst(e);
        }else {
            //prev为新添加节点node之前的节点
            Node prev=head;
            //带插入的节点前面的那个节点
            for (int i =0;i<index-1;i++){
                prev=prev.next;
            }

            Node node =new Node(e);
            node.next=prev.next;
            prev.next=node;

            size++;
        }
    }

    //在链表末尾添加新元素e
    public void addLast(E e){
        add(size,e);
    }
}
