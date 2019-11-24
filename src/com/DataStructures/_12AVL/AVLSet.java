package com.DataStructures._12AVL;

/**
 * Created by Administrator on 2019/11/24.
 */
public class AVLSet <E extends Comparable<E>> implements Set<E> {

    private AVLTree<E,Object> avl;

    public AVLSet(){
        avl=new AVLTree<E, Object>();
    }

    @Override
    public void add(E e) {
        avl.add(e,null);
    }

    @Override
    public void remove(E e) {
        avl.remove(e);

    }

    @Override
    public boolean contains(E e) {
//        return false;
        return avl.contains(e);
    }

    @Override
    public int getSize() {
//        return 0;
        return avl.getSize();
    }

    @Override
    public boolean isEmpty() {
//        return false;
        return avl.isEmpty();
    }


}
