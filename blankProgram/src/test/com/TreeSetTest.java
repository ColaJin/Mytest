package com;

import entity.User;
import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * 1.向TreeSet中添加数据，要求是相同类的对象
 * 2.两种排序方式：自然排序(实现comparable接口)和定制排序
 *
 * 3.自然排序总，比较两个对象是否相同的标准为：compareTo()返回0，不再是equals()
 * 4.定制排序中：比较两个对象是否相同的标准为：compare()返回0，不再是equals()
 */
public class TreeSetTest {
    @Test
    public void Test1() {
        TreeSet set = new TreeSet();
        //添加失败，不能添加不同类数据
        /*set.add(456);
        set.add(123);
        set.add(123);
        set.add("AA");
        set.add("CC");
        set.add(new User("Tom",12));
        //User不重写equals和hashCOde()两个方法就是两个值
        set.add(new User("Tom",12));
        set.add(129);*/

        //举例一：
        /*set.add(34);
        set.add(-34);
        set.add(43);*/

        //举例二：
        set.add(new User("Tom",12));
        set.add(new User("Jerry",32));
        set.add(new User("Jim",12));

        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    @Test
    public void Test2() {
        Comparator com = new Comparator() {
            //按照年龄大小排列
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof User && o2 instanceof User) {
                    User u1 = (User) o1;
                    User u2 = (User) o2;
                    return Integer.compare(u1.getAge(),u2.getAge());
                }else {
                    throw new RuntimeException("输入的数据类型不匹配");
                }
            }
        };
        TreeSet set = new TreeSet(com);

        set.add(new User("Tom",12));
        set.add(new User("Jerry",32));
        set.add(new User("Jim",12));
        set.add(new User("jyd",32));

        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
