package com;

import entity.User;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

public class ForEachTest {

    @Test
    public void Test1() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);
        coll.add(new User("Jerry", 20));

        //for(集合元素的类型 局部变量：集合对象)
        //内部仍然调用迭代器
        for (Object obj : coll) {
            System.out.println(obj);
        }
    }

    @Test
    public void Test2() {
        int[] arr = new int[]{1, 2, 3, 4, 5};

        //for(数组元素的类型 局部变量：数组对象)
        for (int i : arr) {
            System.out.println(i);
        }
    }

    @Test
    public void Test3() {
        String[] arr = new String[]{"MM", "MM", "MM"};

        /*//方式一：普通for循环赋值：更新数组本身值
        for (int i = 0; i < arr.length; i++) {
            arr[i]="GG";
        }*/

        //方式二：增强for循环：新增s不修改数组本身值
        for (String s : arr) {
            s = "GG";
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
