package com;

import entity.User;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Collection接口中声明的方法测试
 *
 * 结论：
 * 向Collection接口的实现类的对象中添加数据obj时要求obj所在的类要重写equals()
 */
public class CollectionTest {
    @Test
    public void test1() {
        Collection coll = new ArrayList();
        coll.add(123);//执行System.out.println(coll.contains(new User("Jerry",20)));调用一次equals()方法
        coll.add(456);//执行System.out.println(coll.contains(new User("Jerry",20)));调用一次equals()方法调用一次equals()方法
        coll.add(new String("Tom"));//执行System.out.println(coll.contains(new User("Jerry",20)));调用一次equals()方法调用一次equals()方法
        coll.add(false);//执行System.out.println(coll.contains(new User("Jerry",20)));调用一次equals()方法调用一次equals()方法
        /*User p =new User("Jerry",20);
        coll.add(p);*/
        coll.add(new User("Jerry",20));//执行System.out.println(coll.contains(new User("Jerry",20)));调用一次equals()方法调用一次equals()方法
        //1.contains(Object obj):判断当前集合中是否包含obj
        boolean contains = coll.contains(123);
        System.out.println(contains);
        //System.out.println(coll.contains(p));//返回true
        System.out.println(coll.contains(new String("Tom")));
        System.out.println(coll.contains(new User("Jerry",20)));//返回false可变成true

        //2.containsAll(Collection coll1):判断形参coll1中所有元素是否都(所有元素)存在当前集合中
        Collection coll1  = Arrays.asList(123, 4567);
        System.out.println(coll.containsAll(coll1));
    }

    @Test
    public void test2() {
        //3.remove(Object obj):从当前集合中移除obj元素
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);
        coll.add(new User("Jerry",20));

        coll.remove(123);
        System.out.println(coll);

        //重写之后相同可以移除成功
        coll.remove(new User("Jerry",20));
        System.out.println(coll);

        //4.removeAll(Collection Coll1)：从当前元素集合中移除coll1所有元素(差集)
        Collection coll1=Arrays.asList(123,4567);
        coll.removeAll(coll1);
        System.out.println(coll);
    }

    @Test
    public void test3() {
        //3.remove(Object obj):从当前集合中移除obj元素
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);
        coll.add(new User("Jerry",20));

        /*//retainAll(Collection coll1)：获取当前集合和coll1集合的交集，并返回给当前集合(交集)
        Collection coll1=Arrays.asList(123,456,789);
        coll.retainAll(coll1);
        System.out.println(coll);*/

        //equals(Object obj)：要想返回true，需要当前集合和形参集合的元素是否相同
        Collection coll1 = new ArrayList();
        //交换顺序(数组存储有序，选用HashSet则没影响)返回false
        coll1.add(456);
        coll1.add(123);
        coll1.add(new String("Tom"));
        coll1.add(false);
        coll1.add(new User("Jerry",20));
        System.out.println(coll.equals(coll1));
    }

    @Test
    public void test4() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);
        coll.add(new User("Jerry",20));

        //7.hashCode():返回当前对象的哈希值
        System.out.println(coll.hashCode());

        //8.集合->数组：toArray():
        Object[] arr = coll.toArray();
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        //拓展：数组--->集合:调用Arrays类的静态方法asList()
        List<String> list = Arrays.asList(new String[]{"11", "BB", "CC"});
        System.out.println(list);

        //一个元素
        List<int[]> arr1 = Arrays.asList(new int[]{123, 456});
        System.out.println(arr1);
        System.out.println(arr1.size());

        //也可以List arr2 = Arrays.asList(123, 456);List arr3 = Arrays.asList(new Integer[]{123, 456});两个元素
        List<Integer> arr2 = Arrays.asList(123, 456);
        System.out.println(arr2);
        System.out.println(arr2.size());

        //9.iterator():返回Iterator接口实例，用于遍历集合元素，放在IteratorTest.java中测试
    }
}
