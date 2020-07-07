package com;

import org.junit.Test;

import java.util.*;

/**
 * /---------Map:双列数据，存储key-value对数据 ----类似于高中的函数：y=f(x)
 * /-----HashMap:作为Map的主要实现类，线程不安全，效率高，存储null的key和value
 * /-----LinkedHashMap：保证遍历map元素时，可以按照添加的顺序实现遍历
 * 原因：在原有的HashMap底层结构基础上，添加了一对指针，指向前一个和后一个元素
 * 对于频繁的遍历操作，此类执行的效率高于HashMap
 * /-----TreeMap:保证按照添加的key-value对进行【爱旭，实现排序遍历。此时考虑key的自然排序和定制排序
 * 底层使用红黑树
 * /-----HashTable:作为古老的实现类，线程安全，效率低，不能存储null的key和value(key或value空指针异常)
 * /-----Propertites：常用来处理配置文件。key和value都是String类型
 * <p>
 * <p>
 * HashMap底层：数组+链表(jdk7及之前)
 * 数组+链表+红黑树(jdk 8)
 * <p>
 * 面试题
 * 1.HashMap底层实现原理
 * 2.HashMap和HashTable的异同
 * 3.CurrentHashMap与HashMap的异同
 * <p>
 * 二、Map结构理解：
 * Map中的key：无序的，不可重复的，使用Set吃没吃及所有key--->key所在的类要重写equals()和hashCode()(以HashMap为例)
 * Map中的value：无序的可重复的，使用Collecton存储所有的value----》value所在类要重写equals()
 * 一个键值对：key-value构成了一个Entry对象
 * Map中的Entry：无序的、不可重复的，使用Set存储的Entry
 * <p>
 * <p>
 * 三、HashMap的底层实现原理？以jdk7为例说明
 * HashMap map = new HashMap();
 * 在实例化以后，底层创建一个长度是16的一维数组Entry[] table
 * ...可能只需过很多次put..
 * map.put(key1,value1):
 * 首先，调用key1所在类的hashCode()计算key1的哈希值，此哈希值经过某种算法计算以后，得到在Ebtry数组中的位置
 * 如果·此位置上的数据为空，此时key1-value1添加成功 ---- 情况1
 * 如果此位置上的数据不为空，意味着次位置存在一个或多个数据(以链表形式存在)，比较key1和已经存在的一个或多个数据的哈希值：
 * 如果key1的哈希值与已经存在的数据的哈希值都不相同，此时key1-value1添加成功  ---- 情况2
 * 如果key1的哈希值与已经存在的某个数据(key2-value2)的哈希值相同。继续比较：调用key1所在类的equalS(key2)比较
 * 如果equals()返回false：此时key1-value1添加成功 ----情况3
 * 如果equals()返回true:使用value1替换相同key的value值(value2)
 * <p>
 * 补充：关于情况2和情况3此时key1-value1和原来的数据已链表方式存储
 * <p>
 * 在不断的添加过程中，会涉及扩容问题：当超出临界值（且要存放的位置非空）扩容为原来容量的2呗，将原有数据复制过来
 * <p>
 * jdk8相较于jdk7在底层实现方面的不同
 * 1. 没有创建一个长度为16的数组
 * 2. jdk 8底层数据是Node[],而非Entry[]
 * 3. 首次调用put()方法时，磁层创建长度为16的数据
 * 4. jdk底层结构：数据+链表。jdk8中的底层结构：数组+链表+红黑树。
 * 当数据的某一个缩影为实质上的元素以链表形式存在的数据个数>8且当前数组的长度>64时，此时此索引位置上的所有数据改为使用红黑树存储
 * <p>
 * DEFAULT_INITIAL_CAPACITY：HashMap的默认容量，16
 * DEFAULT_LOAD_FACTOR：HashMap的默认加载因子：0.75
 * threshold：扩容临界值，=容量*填充因子：16*0.75=12
 * TREEIFY_THRESHOLD：Buckect中链表长度大于该默认值，转换为红黑树：8
 * MIN_TREEIFY_CAPACITY：同种的Node呗树化是最小的hash表容量：64
 * <p>
 * <p>
 * 四、LinkedHashMap底层的实现原理(了解)
 * 源码中:
 * static class Entry<K,V> extends HashMap.Node<K,V> {
 * Entry<K,V> before, after;//能够记录添加元素的先后顺序
 * Entry(int hash, K key, V value, Node<K,V> next) {
 * super(hash, key, value, next);
 * }
 * }
 * <p>
 * 五、Map中定义的方法
 * 添加、删除、修改操作
 * Object put(Object key,Obecy value):将制定的key-value添加到(或修改)当前map对象中
 * void putAll(Map m): 将m中的所有key-value对存放在当前map中
 * Object remove(Object key):移除指定的key-value对，并返回value值
 * void clear():清空当前map中的所有数据
 * <p>
 * 元素查询操作：
 * Object get(Object key):获取指定key对应的value
 * boolean containsKey(Object key):是否包含指定的key
 * boolean containsValue(Object value):是否包含指定的value
 * int size():返回map中key-value对的个数
 * boolean isEmpty():判断当前map和参数对象obj是否相等
 * <p>
 * 元视图操作方法
 * Set keySet():返回所有key构成的Set集合
 * Collection values():返回所有value构成的Collection集合
 * Set entrySet():返回所有key-value对构成的Set集合
 * 无插入(无序)
 */
public class MapTest {
    @Test
    public void test1() {
        Map map = new HashMap();
        //map = new Hashtable();
        map.put(null, 123);
    }

    @Test
    public void test2() {
        Map map = new HashMap();
        //map = new LinkedHashMap();
        map.put(123, "AA");
        map.put(345, "BB");
        map.put(12, "CC");
        System.out.println(map);
    }

    @Test
    public void test3() {
        Map map = new HashMap();
        //添加
        map.put("AA", 123);
        map.put(345, 123);
        map.put("CC", 12);
        //修改
        map.put("AA", 87);
        System.out.println(map);

        Map map1 = new HashMap();
        map1.put("BB", 123);
        map1.put("DD", 123);
        map.putAll(map1);
        System.out.println(map);

        Object value = map.remove("CC");
        System.out.println(value);
        System.out.println(map);

        map.clear();//map = null操作不同
        System.out.println(map.size());
    }

    @Test
    public void test4() {
        Map map = new HashMap();
        map.put("AA", 123);
        map.put(345, 123);
        map.put("CC", 12);

        System.out.println(map.get(345));

        boolean isExist = map.containsKey("BB");
        System.out.println(isExist);

        isExist = map.containsValue(123);
        System.out.println(isExist);

        map.clear();
        System.out.println(map.isEmpty());
    }

    @Test
    public void test5() {
        Map map = new HashMap();
        map.put("AA", 123);
        map.put(345, 1234);
        map.put("CC", 12);

        //遍历所有key集：keySet()
        Set set = map.keySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println();

        //遍历所有的value集：values()
        Collection values = map.values();
        for (Object obj : values) {
            System.out.println(obj);
        }
        System.out.println();

        //遍历所有的key-value：
        //方式一：entrySet()
        Set entrySet = map.entrySet();
        Iterator iterator1 = entrySet.iterator();
        while (iterator1.hasNext()) {
            Object obj = iterator1.next();
            //entrySet集合的元素都是entry
            Map.Entry entry = (Map.Entry) obj;
            System.out.println(entry.getKey() + "-->" + entry.getValue());
        }
        System.out.println();
        //方式二：
        Set keySet = map.keySet();
        Iterator iterator2 = keySet.iterator();
        while (iterator2.hasNext()) {
            Object key = iterator2.next();
            Object value = map.get(key);
            System.out.println(key + "=====" + value);
        }

    }
}
