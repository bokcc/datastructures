package com.bokcc.adt.list;

/**
 * @author : bokkcc
 * @since : 2023.01.20
 */
public interface IQueue<E> {
    /**
     * 判断队列是否为空。
     * @return 如果队列为空返回 true, 否则返回 false
     */
    boolean empty();

    /**
     * 向队列中添加一个元素。
     * @param e 要添加的元素
     * @return 添加成功返回 true, 否则返回 false
     */
    boolean offer(E e);

    /**
     * 取出队列中第一个元素，但不删除。
     * @return 队头元素
     * @throws java.util.NoSuchElementException 当队列为空时抛出
     */
    E peek();

    /**
     * 取出队列中第一个元素，并且删除。
     * @return 对头元素
     * @throws java.util.NoSuchElementException 当队列为空时抛出
     */
    E pull();



}
