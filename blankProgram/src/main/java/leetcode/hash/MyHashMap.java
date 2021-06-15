package leetcode.hash;

import java.util.Iterator;
import java.util.LinkedList;

public class MyHashMap {
    static class Pair {
        private int key;
        private int value;

        public Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }

        // 可以优化增加set和get方法
    }

    private static LinkedList[] list;
    private static final int BASE = 769;

    /**
     * Initialize your data structure here.
     */
    public MyHashMap() {
        list = new LinkedList[BASE];
        for (int i = 0; i < BASE; i++) {
            list[i] = new LinkedList<Pair>();
        }
    }

    /**
     * value will always be non-negative.
     */
    public void put(int key, int value) {
        int h = hash(key);
        Iterator iterator = list[h].iterator();
        while (iterator.hasNext()) {

            Pair pair = (Pair) iterator.next();
            if (pair.key == key) {
                // 值覆盖
                pair.value = value;
                return;
            }
        }
        Pair pair = new Pair(key, value);
        list[h].offerLast(pair);
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
     */
    public int get(int key) {
        int h = hash(key);
        Iterator iterator = list[h].iterator();
        while (iterator.hasNext()) {
            Pair pair = (Pair) iterator.next();
            if (pair.key == key) {
                return pair.value;
            }
        }
        // 没找到
        return -1;
    }

    /**
     * Removes the mapping of the specified value key if this map contains a mapping for the key
     */
    public void remove(int key) {
        int h = hash(key);
        Iterator iterator = list[h].iterator();
        while (iterator.hasNext()) {
            Pair pair = (Pair) iterator.next();
            if (pair.key == key) {
                list[h].remove(pair);
                // 报错 ConcurrentModificationException
                return;
            }
        }
    }

    public static int hash(int key) {
        return key % BASE;
    }
}
