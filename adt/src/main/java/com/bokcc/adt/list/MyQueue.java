package com.bokcc.adt.list;

import java.util.NoSuchElementException;

/**
 * @author : bokkcc
 * @since : 2023.01.20
 */
public class MyQueue<E> implements IQueue<E>{

    private QNode<E> header;

    private QNode<E> tail;

    private int size = 0;

    @Override
    public boolean empty() {
        return size == 0;
    }

    @Override
    public boolean offer(E e) {
        linkLast(e);
        return true;
    }

    @Override
    public E peek() {
        if(size == 0){
            throw new NoSuchElementException();
        }
        return header.item;
    }

    @Override
    public E pull() {
       if(size == 0){
           throw new NoSuchElementException();
       }

       return unlinkFirst();
    }

    private E unlinkFirst(){
       assert header != null;
       var e = header.item;

       header = header.next;
       if(size == 1){
           tail = null;
       }

       size -= 1;

       return e;
    }

    private void linkLast(E e){
        var x = new QNode<E>(e,null);
        if (size == 0) {
            header = tail = x;
        }else {
            tail.next = x;
            tail = x;
        }

        size += 1;
    }

    private static class QNode<E>{
        E item;
        QNode<E> next;

        QNode(E item ,QNode<E> next){
           this.item = item;
           this.next = next;
        }
    }
}
