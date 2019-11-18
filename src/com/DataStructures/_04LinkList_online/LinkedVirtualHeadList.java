package com.DataStructures._04LinkList_online;

/**
 * Created by Administrator on 2018/12/14.
 */
public class LinkedVirtualHeadList<E> {
    //链表中节点类
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
    //************************************************************************
    //1.基本信息dummyhead和size
    private Node dummyhead;
    private int size;
    //************************************************************************
    //2.构造函数
    public LinkedVirtualHeadList(){
        dummyhead =new Node(null,null);
        size=0;
    }
    //************************************************************************
    //3.获取基本信息
    // 获取链表中的元素个数
    public int getSize(){
        return size;
    }

    // 返回链表是否为空
    public boolean isEmpty(){
        return size==0;
    }

    //************************************************************************
    //4.添加元素
    /**
     * 4.1在链表头添加新的元素e
     * @param e
     */
    public void addFirst(E e){
//        Node node=new Node(e);
//        node.next=head;
//        head=node;

//        head=new Node(e,head);
//        size++;
        add(0,e);
    }

    /**
     * 4.2在链表的index(0-based)位置添加新的元素e
     * @param index
     * @param e
     */
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

    /**
     * 4.3 在链表末尾添加新元素e
     * @param e
     */
    public void addLast(E e){
        add(size,e);
    }

    //************************************************************************
    //5.查询元素

    /**
     * 5.1 获得链表的第index(0-based)个位置的元素
     * @param index
     * @return
     */
    public E get(int index){
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed. Illegal index.");

        Node cur=dummyhead.next;
        for (int i=0;i<index;i++){
            cur=cur.next;
        }
        return cur.e;
    }

    /**
     * 5.2获得链表的第一个元素
     * @return
     */
    public E getFirst(){
        return get(0);
    }

    /**
     * 5.3 获得链表的最后一个元素
     * @return
     */
    public E getLast(){
        return get(size - 1);
    }

    //************************************************************************
    //6.修改元素
    /**
     * 6.1 修改链表第index的元素为e
     * @param index
     * @param e
     */
    public void set(int index,E e){
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Set failed. Illegal index.");

        Node cur=dummyhead.next;
        for (int i=0;i<index;i++){
            cur=cur.next;
        }
        cur.e=e;
    }

    /**
     * 6.2 查找链表中是否有元素e
     * @param e
     * @return
     */
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


    //************************************************************************
    //7.删除元素
    /**
     * 7.1 删除index位置的元素，返回删除元素
     * @param index
     * @return
     */
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

    /**
     * 7.2 从链表中删除第一个元素, 返回删除的元素
     * @return
     */
    public E removeFirst(){
        return remove(0);
    }

    /**
     * 7.3 从链表中删除最后一个元素, 返回删除的元素
     * @return
     */
    public E removeLast(){
        return remove(size-1);
    }

    /**
     * 7.4 从链表中删除元素e
     * @param e
     */
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

}
