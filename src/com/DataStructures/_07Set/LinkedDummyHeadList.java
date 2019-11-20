package com.DataStructures._07Set;

/**
 * Created by Administrator on 2018/12/14.
 */
public class LinkedDummyHeadList<E> {
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

    private Node dummyhead;
    private int size;

    public LinkedDummyHeadList(){
        dummyhead =new Node(null,null);
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

//        head=new Node(e,head);
//        size++;
        add(0,e);
    }

    // 在链表的index(0-based)位置添加新的元素e
    public void add(int index,E e){
        if(index < 0 || index > size)
            throw new IllegalArgumentException("Add failed. Illegal index.");


        Node prev=dummyhead;
        //带插入的节点前面的那个节点
        for (int i =0;i<index;i++){
            prev=prev.next;
        }

        Node node =new Node(e);
        node.next=prev.next;
        prev.next=node;

        size++;

    }

    //在链表末尾添加新元素e
    public void addLast(E e){
        add(size,e);
    }

    // 获得链表的第index(0-based)个位置的元素
    // 在链表中不是一个常用的操作，练习用：）
    public E get(int index){
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed. Illegal index.");

        Node cur=dummyhead.next;
        for (int i=0;i<index;i++){
            cur=cur.next;
        }
        return cur.e;
    }

    // 获得链表的第一个元素
    public E getFirst(){
        return get(0);
    }

    // 获得链表的最后一个元素
    public E getLast(){
        return get(size - 1);
    }

    //修改链表第index的元素为e
    public void set(int index,E e){
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Set failed. Illegal index.");

        Node cur=dummyhead.next;
        for (int i=0;i<index;i++){
            cur=cur.next;
        }
        cur.e=e;
    }

    //查找链表中是否有元素e
    public boolean contains(E e){
        Node cur=dummyhead.next;
        while (cur!=null){
            if(cur.e.equals(e)){
                return true;
            }
            cur=cur.next;
        }
        return false;
    }

    @Override
    public String toString(){
        StringBuilder res=new StringBuilder();
        Node cur=dummyhead.next;
        while (cur!=null){
            res.append(cur+"->");
            cur=cur.next;
        }
//
//        for(Node cur = dummyhead.next ; cur != null ; cur = cur.next)
//            res.append(cur + "->");

        res.append("NULL");
        return res.toString();
    }

    //删除index位置的元素，返回删除元素
    public E remove(int index){
        if(index<0||index>=size)
            throw new IllegalArgumentException("Remove failed. Index is illegal.");

        Node prev=dummyhead;
        for (int i=0;i<index;i++){
            prev=prev.next;
        }

        Node retNode=prev.next;
        prev.next=retNode.next;
        retNode.next=null;//这个是为了java垃圾回收

        size--;
        return retNode.e;
    }

    // 从链表中删除第一个元素, 返回删除的元素
    public E removeFirst(){
        return remove(0);
    }

    // 从链表中删除最后一个元素, 返回删除的元素
    public E removeLast(){
        return remove(size-1);
    }
    // 从链表中删除元素e
    public void removeElement(E e){
        Node prev=dummyhead;
        while (prev.next!=null){
            if(prev.next.equals(e))
                break;
            prev=prev.next;
        }

        if(prev.next!=null){
            Node delNode=prev.next;
            prev.next=delNode.next;
            delNode.next=null;
            size--;
        }
    }


}
