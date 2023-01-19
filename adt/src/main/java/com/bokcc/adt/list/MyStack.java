package com.bokcc.adt.list;


import java.util.EmptyStackException;

/**
 * @author : bokkcc
 * @since : 2023.01.20
 */
public class MyStack<E> implements IStack<E> {
    private SNode<E> header;

    private int size = 0;
    @Override
    public boolean empty() {
        return size == 0;
    }

    @Override
    public E peek() {
        if(size == 0){
            throw new EmptyStackException();
        }

        return header.item;
    }

    @Override
    public E pop() {
        if(size == 0 ){
            throw new EmptyStackException();
        }

        return unlinkFirst();
    }

    @Override
    public boolean push(E e) {
        linkFirst(e);
        return true;
    }

    private E unlinkFirst(){
        if(size == 0) return null;
        var e = header.item;

        header = header.next;
        size -= 1;
        return e;
    }

    private void linkFirst(E e){
        header = new SNode<E>(e,header);

        size += 1;
    }


    private static class SNode<E> {
        SNode<E> next;

        E item;

        SNode(E item, SNode<E> next) {
            this.next = next;
            this.item = item;
        }
    }
}