package com;

import entity.User;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/**
 * 集合元素遍历操作，使用迭代器Iterator接口
 * GOF(设计模式)给迭代器定义为：提供一种方法访问一个rongqi对象的各个元素，而又不需暴露该对象的内部细节
 *
 * 1.内部方法：hasNext()和next()搭配使用
 * 2.集合对象每次调用iterator()方法都得到一个全新的迭代器对象，默认游标都在集合的第一个元素之前
 * 3.内部定义remove()，可以在遍历的时候，删除集合的元素。此方法不同于集合直接调用remove()
 *
 */
public class IteratorTest {
    @Test
    public void test1() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);
        coll.add(new User("Jerry",20));

        Iterator iterator = coll.iterator();
        //方式一：
        /*System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        //报异常：NoSuchElementException
        System.out.println(iterator.next());*/

        /*//方式二:不推荐
        for (int i = 0; i < coll.size(); i++) {
            System.out.println(iterator.next());
        }*/

        //方式三：推荐
        //hasNext()：判断是否还有下一个元素
        while (iterator.hasNext()) {
            //next():指针下一，将下移以后集合位置上的元素返回
            System.out.println(iterator.next());
        }
    }

    @Test
    public void test2() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);
        coll.add(new User("Jerry",20));

        Iterator iterator = coll.iterator();

        /*//错误方式一：跳着输出，NoSuchElementException
        while ((iterator.next()) != null) {
            //next():指针下一，将下移以后集合位置上的元素返回
            System.out.println(iterator.next());
        }*/

        //错误方式二：一直输出第一个，获取全新的集合对象
        while (coll.iterator().hasNext()) {
            System.out.println(coll.iterator().next());
        }
    }

    //测试Iterator中的remove()
    //未调用next()或在上一次调用next方法后已经调用remove方法再次调用会报IllegalStateException
    @Test
    public void test3() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);
        coll.add(new User("Jerry",20));

        //删除集合中“Tom”元素
        Iterator iterator = coll.iterator();
        while (iterator.hasNext()) {
            //报异常:IllegalStateException
            //iterator.remove();
            Object obj = iterator.next();
            if ("Tom".equals(obj)){
                iterator.remove();
                //报异常:IllegalStateException
                //iterator.remove();
            }
        }

        //遍历集合
        iterator = coll.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
