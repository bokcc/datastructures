package com.bokcc.adt.list;


/**
 * @author : bokkcc
 * @since : 2023.01.20
 */
public interface IStack<E> {

    /**
     * 判断栈是否为空。
     * @return 如果栈为空返回 true, 否则返回 false
     */
    boolean empty();

    /**
     * 从栈中取出第一个元素，但是并不删除。
     * @return 栈中的第一个元素
     * @throws java.util.EmptyStackException 当栈为空的时候抛出
     */
    E peek();

    /**
     * 从栈中取出第一个元素，并且删除。
     * @return 栈中的第一个元素。
     * @throws java.util.EmptyStackException 当栈为空的时候抛出
     */
    E pop();

    /**
     * 向栈中添加一个元素。
     * @param e 要添加的元素
     * @return 添加成功返回 true, 添加失败返回 false
     */
    boolean push(E e);
}
