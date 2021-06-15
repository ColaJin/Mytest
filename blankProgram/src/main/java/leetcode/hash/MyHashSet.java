package leetcode.hash;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * 通过Iterator进行遍历,增删操作都需要留意是否会触发ConcurrentModificationException异常
 */
public class MyHashSet {
    static LinkedList[] list = null;
    // 设置成final，
    static final int BASE = 769;
    /**
     * Initialize your data structure here.
     */
    public MyHashSet() {
        list = new LinkedList[BASE];
        for (int i = 0; i < BASE; i++) {
            // 指明int类型的LinkedList
            list[i] = new LinkedList<Integer>();
        }
    }

    public void add(int key) {
        int h = hash(key);
        /*// 遍历list[h]，比较是否存储了key的值
        for (int i = 0; i < list[h].size(); i++) {
            if (list[h].get(i).equals(key)) {
                return;
            }
        }*/
        // 可以优化使用Iterator
        Iterator<Integer> iterator = list[h].iterator();
        while (iterator.hasNext()) {
            Integer element = iterator.next();
            if (element == key) {
                return ;
            }
        }

        list[h].offerLast(key);

    }

    public void remove(int key) {
        int h = hash(key);
        /*// 遍历list[h]，比较是否存储了key的值
        for (int i = 0; i < list[h].size(); i++) {
            if (list[h].get(i).equals(key)) {
                list[h].remove();
            }
        }*/
        // 可以优化使用Iterator
        Iterator<Integer> iterator = list[h].iterator();
        while (iterator.hasNext()) {
            Integer element = iterator.next();
            if (element == key) {
                // 移除指定元素加参数
                list[h].remove(element);
                // 返回否则报错,ConcurrentModificationException
                return;
            }
        }
    }

    /**
     * Returns true if this set contains the specified element
     */
    public boolean contains(int key) {
        int h = hash(key);

        /*for (int i = 0; i < list[h].size(); i++) {
            if (list[h].get(i).equals(key)) {
                return true;
            }
        }*/
        Iterator<Integer> iterator = list[h].iterator();
        while (iterator.hasNext()) {
            Integer element = iterator.next();
            if (element == key) {
                return true;
            }
        }

        return false;
    }

    public static int hash(int key) {
        return key % BASE;
    }

    public static void main(String[] args) {
        MyHashMap myHashMap = new MyHashMap();
        myHashMap.put(1, 1); // myHashMap 现在为 [[1,1]]
        myHashMap.put(2, 2); // myHashMap 现在为 [[1,1], [2,2]]
        myHashMap.get(1);    // 返回 1 ，myHashMap 现在为 [[1,1], [2,2]]
        myHashMap.get(3);    // 返回 -1（未找到），myHashMap 现在为 [[1,1], [2,2]]
        myHashMap.put(2, 1); // myHashMap 现在为 [[1,1], [2,1]]（更新已有的值）
        myHashMap.get(2);    // 返回 1 ，myHashMap 现在为 [[1,1], [2,1]]
        myHashMap.remove(2); // 删除键为 2 的数据，myHashMap 现在为 [[1,1]]
        myHashMap.get(2);    // 返回 -1（未找到），myHashMap 现在为 [[1,1]]
    }

}
