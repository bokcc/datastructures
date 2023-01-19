package com.bokcc.adt.list;


import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author : bokkcc
 * @since : 2023.01.15
 */
public class MyLinkedList<E> implements IList<E> {
    private int size = 0;
    private LNode<E> front;

    private LNode<E> tail;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void add(E item) {
        linkFirst(item);
    }

    @Override
    public void add(E item, int index) {
        checkPositionIndex(index);
        if (index == size) {
            linkLast(item);
        } else {
            linkBefore(item, node(index));
        }
    }

    @Override
    public E delete(int index) {
        checkElementIndex(index);
        return unlink(node(index));
    }

    @Override
    public int find(E item) {
        return indexOf(item);
    }

    @Override
    public boolean contains(E item) {
        return indexOf(item) != -1;
    }

    @Override
    public E header() {
        return front.item;
    }

    @Override
    public E tail() {
        return tail.item;
    }

    @Override
    public E retrieve(int index) {
        checkElementIndex(index);
        return node(index).item;
    }

    @Override
    public Iterator<E> iterator() {
        return new Itr();
    }

    private void linkFirst(E item) {
        var node = new LNode<E>(null, item, front);
        if (front == null) {
            tail = node;
        } else {
            front.prev = node;
        }
        front = node;

        size += 1;
    }

    private void linkLast(E item) {
        var node = new LNode<E>(tail, item, null);
        if (tail == null) {
            front = node;
        } else {
            tail.next = node;
        }
        tail = node;

        size += 1;
    }

    private void linkBefore(E item, LNode<E> x) {
        assert x != null;
        var pred = x.prev;
        var newNode = new LNode<>(pred, item, x);
        x.prev = newNode;
        if (pred == null) {
            front = newNode;
        } else {
            pred.next = newNode;
        }
        size++;
    }

    private E unlink(LNode<E> x) {
        assert x != null;
        var element = x.item;
        var prev = x.prev;
        var next = x.next;

        if (prev == null) {
            front = next;
        } else {
            prev.next = next;
            x.prev = null;
        }

        if (next == null) {
            tail = prev;
        } else {
            next.prev = prev;
            x.next = null;
        }
        x.item = null;
        size -= 1;

        return element;
    }

    // copy from LinkedList.java

    /**
     * Tells if the argument is the index of an existing element.
     */
    private boolean isElementIndex(int index) {
        return index >= 0 && index < size;
    }

    /**
     * Tells if the argument is the index of a valid position for an
     * iterator or an add operation.
     */
    private boolean isPositionIndex(int index) {
        return index >= 0 && index <= size;
    }

    /**
     * Constructs an IndexOutOfBoundsException detail message.
     * Of the many possible refactorings of the error handling code,
     * this "outlining" performs best with both server and client VMs.
     */
    private String outOfBoundsMsg(int index) {
        return "Index: " + index + ", Size: " + size;
    }

    private void checkElementIndex(int index) {
        if (!isElementIndex(index)) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
    }

    private void checkPositionIndex(int index) {
        if (!isPositionIndex(index)) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
    }


    private LNode<E> node(int index) {
        LNode<E> node;
        if (index > (size >> 1)) {
            node = tail;
            for (int i = size - 1; i > index; i--) {
                node = node.next;
            }

        } else {
            node = front;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }

        }
        return node;
    }

    private int indexOf(E e) {
        var index = 0;
        if (e == null) {
            for (var x = front; x != null; x = x.next) {
                if (x.item == null) {
                    return index;
                }
                index += 1;
            }
        } else {
            for (var x = front; x != null; x = x.next) {
                if (e.equals(x.item)) {
                    return index;
                }
                index += 1;
            }
        }

        return -1;
    }


    private static class LNode<E> {
        E item;
        LNode<E> prev;
        LNode<E> next;

        LNode(LNode<E> prev, E item, LNode<E> next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }

    private class Itr implements Iterator<E> {

        private LNode<E> next = (size == 0) ? null : front;
        private int nextIndex = 0;

        @Override
        public boolean hasNext() {
            return nextIndex < size;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            var x = next;
            next = next.next;
            nextIndex += 1;
            return x.item;
        }

    }

    @Override
    public String toString() {
        var it = new Itr();
        if (!it.hasNext()) {
            return "[]";
        }
        var strBuilder = new StringBuilder().append('[');
        for (; ; ) {
            var e = it.next();
            strBuilder.append(e == this ? "(this collection)" : e);
            if (!it.hasNext()) {
                return strBuilder.append("]").toString();
            }

            strBuilder.append(' ').append(',');
        }
    }
}
