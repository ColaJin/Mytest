package leetcode.hash;

import java.util.*;

public class FindRestaurant {

    public static void main(String[] args) {
        String[] list1 = new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] list2 = new String[]{"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"};
        String[] rs = findRestaurantByHash(list1, list2);
        for (String str : rs) {
            System.out.println(str);
        }
    }

    public static String[] findRestaurant(String[] list1, String[] list2) {
        // Map存储字符串和字符串所在的索引
        // 记录最小的索引
        int index = 0;
        // 动态数组list存储最后toArray
        String[] rs = new String[list2.length + list2.length];
        HashMap<String, Integer> map = new HashMap<>();
        int min = Integer.MIN_VALUE;
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }

        for (int i = 0; i < list2.length; i++) {
            if (map.containsKey(list2[i])) {
                // 存在相同的元素
                if (min == Integer.MIN_VALUE) {
                    // 可能相同元素在00位置此时的min也是0
                    min = map.get(list2[i]) + i;
                    rs[index] = list2[i];
                    index++;
                } else if (min == map.get(list2[i]) + i) {
                    // 多个相同的元素
                    rs[index] = list2[i];
                    index++;
                } else if (min > map.get(list2[i]) + i) {
                    // 索引更小的相同元素
                    // 此时数组中可能存在多个
                    rs = new String[list2.length + list1.length];
                    index = 0;
                    rs[index] = list2[i];
                    index++;
                }
            }
        }

        return Arrays.copyOfRange(rs, 0, index);
    }

    public static String[] findRestaurantByList(String[] list1, String[] list2) {
        // Map存储字符串和字符串所在的索引
        // 动态数组list存储最后toArray
        List<String> list = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        // 设置最大
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }

        for (int i = 0; i < list2.length; i++) {
            if (map.containsKey(list2[i])) {
                // 存在相同的元素
                if (min == map.get(list2[i]) + i) {
                    list.add(list2[i]);
                }
                if (min > map.get(list2[i]) + i) {
                    // 索引更小的相同元素
                    // 此时数组中可能存在多个
                    min = map.get(list2[i]) + i;
                    list.clear();
                    list.add(list2[i]);
                }
            }
        }
        String[] strings = new String[list.size()];

        return list.toArray(strings);
    }


    public static String[] findRestaurantByHash(String[] list1, String[] list2) {
        // map直接存储，索引i+j和结果list，遍历map最后返回list.toArray
        HashMap<Integer, List<String>> map = new HashMap<>();
        // 记录最小的索引设置最大
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < list1.length; i++) {
            for (int j = 0; j < list2.length; j++) {
                // 必须使用equals比较字符串(idea可以编译通过)
                if (list1[i].equals(list2[j])) {
                    // 判断是否是相同的字符串
                    if (!map.containsKey(i + j)) {
                        ArrayList<String> list = new ArrayList<>();
                        list.add(list2[j]);
                        map.put(i + j, list);
                    } else {
                        map.get(i + j).add(list2[j]);
                    }
                }
            }
        }

        int size = 0;
        // 遍历map算最小的索引和
        for (Map.Entry<Integer, List<String>> entry : map.entrySet()) {
            if (entry.getKey() < min) {
                min = entry.getKey();
                size = entry.getValue().size();
            }
        }

        return map.get(min).toArray(new String[size]);
    }

}
