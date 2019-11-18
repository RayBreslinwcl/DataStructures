package com.DataStructures._02ArraysStackAndQueue;

/**
 * Created by Administrator on 2018/12/13.
 */
public class _05ArrayQueue<E> implements _05queue<E> {
    private _00ArrayDynamic<E> array;
    public _05ArrayQueue(int capacity){
        array=new _00ArrayDynamic<>(capacity);
    }
    public _05ArrayQueue(){
        array=new _00ArrayDynamic<>();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }

    @Override
    public E dequeue() {
        return array.removeFirst();
    }

    @Override
    public E getFront() {
        return array.getFirst();
    }

    public int getCapacity(){
        return array.getCapacity();
    }

    public String toString(){
        StringBuilder res=new StringBuilder();
        res.append("Queue:");
        res.append("front [");
        for (int i=0;i<array.getSize();i++){
            res.append(array.get(i));
            if (i!=array.getSize()-1){
                res.append(", ");
            }
        }
        res.append("] tail");
        return res.toString();
    }

    public static void main(String[] args) {
        _05ArrayQueue<Integer> queue=new _05ArrayQueue<>(10);
        for (int i=0;i<16;i++){
            queue.enqueue(i);
            System.out.println(queue);

            if (i%3==2){
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}
