package com.bokcc.adt.list;

/**
 * @author : bokkcc
 * @since : 2023.01.15
 */
public interface IList<E> extends Iterable<E> {

    /**
     * 获取表中现有的元素个数
     *
     * @return 表中元素个数
     */
    int size();


    /**
     * 判断表是否为空
     *
     * @return 如果表为空返回true,否则返回false
     */
    boolean isEmpty();

    /**
     * 向表中添加一个元素
     * 规定:不指定位置时插入到表头
     * @param item 要插入的元素实例
     */
    void add(E item);

    /**
     * 向表中指定位置插入一个元素，规定第一个元素的位置为 0 。
     * index值范围为 [0, size()] , 值为 0 时插入到第一个位置，值为 size() 时插入到最后一个位置。
     * @param item 要插入的元素实例
     * @param index 插入的位置
     */
    void add(E item, int index);

    /**
     * 删除指定位置的元素。
     * 规定：当索引值超出数组范围时抛出异常
     * @param index 要删除的元素的位置，值的范围为 [0 , size()-1]
     * @return 删除成功返回true, 删除失败返回false。
     */
    E delete(int index);

    /**
     * 查找一个元素在表中的位置。
     * 若果元素存在于表中则返回其位置，否则返回 -1 。
     * @param item 要查找的元素的引用
     * @return 如果元素存在表中则返回其在表中的位置，如果不存在则返回 -1 。
     */
    int find(E item);

    /**
     * 判断表中是否存在 item。
     * @param item 要寻找的元素引用
     * @return 如果表中存在 item 则返回 true ,否则返回 false 。
     */
    boolean contains(E item);

    /**
     * 获取表中第一个元素。
     * @return 表中第一个元素
     */
    E header();

    /**
     * 获取表中最后一个元素
     * @return 表中最后一个元素
     */
    E tail();

    /**
     * 获取表中index位置的元素
     * @param index 要取到的元素在表中的位置
     * @return 表中index位置的元素
     */
    E retrieve(int index);


}
