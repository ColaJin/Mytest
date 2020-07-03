package com.test;

import entity.User;
import org.junit.Test;

import java.util.*;

public class MyTest {

    @Test
    public void test1() {

        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);
        Iterator iterator = coll.iterator();
        while (iterator.hasNext()) {
            //iterator.remove();
            Object obj = iterator.next();
            if ("Tom".equals(obj)) {
                iterator.remove();
            }
        }
        iterator = coll.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        ArrayList list = new ArrayList();
        LinkedList linkedList = new LinkedList();
        linkedList.add(123);

    }

    @Test
    public void test2() {
        TreeSet set = new TreeSet();

        set.add(123);
        set.add(456);
        set.add(-34);

        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {

            System.out.println(iterator.next());
        }

    }

    @Test
    public void test3() {
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

        TreeSet<User> set = new TreeSet<User>(com);
        set.add(new User("Tom",12));
        set.add(new User("Jerry",12));
        set.add(new User("Mike",10));

        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {

            System.out.println(iterator.next());
        }
    }

    @Test
    public void test4() {
        List list = new ArrayList();
        list.add(new Integer(1));
        list.add(new Integer(2));
        list.add(new Integer(2));
        list.add(new Integer(3));
        list.add(new Integer(3));

        List newList = duplicateList(list);
        for (Object integer :newList) {
            System.out.println(integer);
        }

    }

    public static List duplicateList(List list){
        HashSet set = new HashSet();
        set.addAll(list);
        return new ArrayList(set);
    }


    @Test
    public void test5() {
        HashSet hashSet = new HashSet();
         Person p1 = new com.test.Person(1001,"AA");
         Person p2 = new Person(102,"BB");

        //entity.Person p3 = new entity.Person(1001,"AA");
        //entity.Person p4 = new entity.Person(102,"BB");

        hashSet.add(p1);
        hashSet.add(p2);
        //此时输出结果[Person{id=1001, name='AA'}, Person{id=102, name='BB'}]
        System.out.println(hashSet);

        //Person类同级目录下可以调用方法否则不可以
        p1.name = "CC";
        //p3.setName("CC");
        hashSet.remove(p1);
        //Person类没有重写hashCode()和equals()方法时输出[Person{id=102, name='BB'}]
        //重写之后输出[Person{id=1001, name='CC'}, Person{id=102, name='BB'}]
        System.out.println(hashSet);

        hashSet.add(new Person(1001,"CC"));
        //Person类没有重写hashCode()和equals()方法时输出[Person{id=102, name='BB'}, Person{id=1001, name='CC'}]
        //重写之后输出[Person{id=1001, name='CC'}, Person{id=1001, name='CC'}, Person{id=102, name='BB'}]
        System.out.println(hashSet);

        hashSet.add(new Person(1001,"AA"));
        //Person类没有重写hashCode()和equals()方法时输出[Person{id=102, name='BB'}, Person{id=1001, name='CC'}, Person{id=1001, name='AA'}]
        //重写之后输出[Person{id=1001, name='CC'}, Person{id=1001, name='CC'}, Person{id=1001, name='AA'}, Person{id=102, name='BB'}]
        System.out.println(hashSet);

    }
}
