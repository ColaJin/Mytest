package com;

import entity.User;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Exercie {
    @Test
    public void testListRemove() {
        ArrayList list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        updataList(list);
        System.out.println(list);
    }

    private void updataList(List list) {
        //list.remove(2);//删除索引2
        list.remove(new Integer(2));//删除数据2
    }
}
