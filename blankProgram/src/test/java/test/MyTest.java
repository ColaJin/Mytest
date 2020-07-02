package java.test;

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
        set.add(new User("Jerry",13));
        set.add(new User("Mike",10));

        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {

            System.out.println(iterator.next().toString());
        }
    }
}
