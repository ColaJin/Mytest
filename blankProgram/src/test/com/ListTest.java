package com;

import entity.User;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Collection接口：单列集合，用来存储一个一个对象
 * 1.List接口：存储有序的、可重复的数据-->动态数组，替换原有数组
 * ArrayList：作为List接口的主要实现类，线程不安全，效率高，底层使用Object[] elementData存储
 * LinkedList：对于频繁的插入、删除操作，使用此类效率比ArrayList高，底层使用双向链表存储
 * Vector：作为List接口的古老实现实现类，线程安全，效率低，底层使用Object[] elementData存储
 * <p>
 * 2.ArrayList源码分析：
 * 2.1 jdk7情况下
 * ArrayList list = new ArrayList();//底层创建长度是10的Object[]数组elementData
 * list.add("123");//elementData[0] = new Integer(123);
 * ···
 * list.add(11);//如果此次添加导致底层elementData数组容量不够，则扩容
 * 默认情况下，扩容原来容量的1.5倍，同时需要将原有数组的数据复制到新的数组中
 * 结论：建议开发中使用带参的构造器ArrayList list = new ArrayList(int capacity)
 * 2.2jdk8情况下
 * ArrayList list = new ArrayList();//底层Object[]数组elementData
 * list.add("123");//第一次调用add()时，底层才创建长度为10的数组，并将数据123添加到elementData[0]
 * ···
 * 后续添加和扩容操作与jdk7无异
 * 2.3小结：jdk7中ArrayList的对象创建类似单例的饿汉式，而jdk8中的ArrayList的对象的创建类似于单例的懒汉式，延迟了数组的创建，节省内存
 * 3.LinkedList源码分析
 * LinkedList linkedList = new LinkedList();//内部声明了Node类型的first和last属性，默认值为null
 * linkedList.add(123);//将123封装到Node中，创建Node对象
 * <p>
 * //其中Node定义为：提现LinkedList的双向链表说法
 * private static class Node<E> {
 * E item;
 * Node<E> next;
 * Node<E> prev;
 * <p>
 * Node(Node<E> prev, E element, Node<E> next) {
 * this.item = element;
 * this.next = next;
 * this.prev = prev;
 * }
 * }
 * <p>
 * 4.Vector
 * <p>
 * jdk7和jdk8中通过Vector()构造器创建对象时底部都创建了长度为10的数组
 * <p>
 * 在扩容方面默认扩容原来数组长度的2倍
 * <p>
 * 含有子类栈
 * <p>
 * 面试题：ArrayList、LinkedList、Vector三者异同
 * 同：三个类都是实现啦List接口，存储数据的特点相同：存储有序的、可重复的数据
 * 不同：见上
 * <p>
 * 5.List常用方法
 */
public class ListTest {

    /**
     * void add(int index,Object ele):在index位置插入ele元素
     * boolean asAll(int index , Collection eles):从index位置开始将else中的所有元素添加进来
     * Object get(int index):获取指定index位置的元素
     * int indexOf(Object obj):返回obj在集合中首次出现的位置
     * int lastIndexOf(Object obj):返回obj在当前集合中末次出现的位置
     * Object remove(int index):移除指定index位置的元素，并返回此元素
     * Object set(int index,Object ele):设置指定index位置的元素ele
     * List subList(int fromIndex,int toIndex):返回从fromIndex到toIndex位置的子集合
     * <p>
     * <p>
     * 总结：常用方法
     * 增：add(Object obj)
     * 删：remove(int index)/remove(Object obj)
     * 改：set(int index,Object ele)
     * 查：get(int index)
     * 插：add(int index,Object ele)
     * 长度：size()
     * 遍历：Iterator迭代器方式
     * 增强for循环
     * 普通的循环
     */
    @Test
    public void Test1() {
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add(new String("AA"));
        list.add(new User("Jerry", 20));
        list.add(456);
        System.out.println(list);

        //void add(int index,Object ele):在index位置插入ele元素
        list.add(1, "BB");
        System.out.println(list);

        //boolean asAll(int index , Collection eles):从index位置开始将else中的所有元素添加进来
        List<Integer> list1 = Arrays.asList(1, 2, 3);
        //list.add(list1);//7个元素
        list.addAll(list1);//9个元素
        System.out.println(list);

        //Object get(int index):获取指定index位置的元素
        System.out.println(list.get(0));

        //Object remove(int index):移除指定index位置的元素，并返回此元素，重载
        Object obj = list.remove(0);
        System.out.println(obj);
        System.out.println(list);

        //Object set(int index,Object ele):设置指定index位置的元素ele
        list.set(0, "cc");
        System.out.println(list);

        //List subList(int fromIndex,int toIndex):返回从fromIndex到toIndex位置的子集合--->左闭右开
        List subList = list.subList(2, 4);
        System.out.println(subList);
        System.out.println(list);//list不改变

    }

    @Test
    public void Test2() {
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add(new String("AA"));
        list.add(new User("Jerry", 20));
        list.add(456);
        System.out.println(list);

        //int indexOf(Object obj):返回obj在集合中首次出现的位置
        int index = list.indexOf(456);
        System.out.println(index);

        //int lastIndexOf(Object obj):返回obj在当前集合中末次出现的位置
        int lastIndex = list.lastIndexOf(456);
        System.out.println(lastIndex);
    }

    @Test
    public void Test3() {
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add(new String("AA"));

        //方式一：Iterator迭代器方式
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        //方式二：增强For循环
        for (Object obj:list) {
            System.out.println(obj);
        }
        
        //方式三：普通for循环
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
