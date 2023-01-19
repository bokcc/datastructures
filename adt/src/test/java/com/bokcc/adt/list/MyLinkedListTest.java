package com.bokcc.adt.list;

import cn.hutool.core.util.RandomUtil;
import org.junit.jupiter.api.Test;


/**
 * @author : bokkcc
 * @since : 2023.01.15
 */

public class MyLinkedListTest {
    @Test
    void testLinkedAdd(){

        var list = new MyLinkedList<>();
        for(int i=0;i<10;i++){
            list.add(RandomUtil.randomString(5));
        }

        System.out.println("list = " + list);
    }


}
