package leetcode.array.easy;

import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author:jinyandong
 * @description:1122. 数组的相对排序
 * @Date:2023/11/28
 */
public class RelativeSortArray {
    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        // arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
        int len = arr1.length;
        int[] rs = new int[len];
        int len2 = arr2.length;
        int pos = 0;
        /*int posOther = 0;
        int[] other = null;
        int size = len - len2;
        if (len > len2) {
            other = new int[size];
        }*/
        // 不可以用Set，存在重复数据导致结果缺失
        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            temp.add(arr1[i]);
        }
        List<Integer> temp1 = new ArrayList<>();
        for (int i = 0; i < len2; i++) {
            temp1.add(arr2[i]);
        }
        List<Integer> list = temp.stream().filter(i -> !temp1.contains(i)).collect(Collectors.toList());
        for (int i = 0; i < len2; i++) {
            for (int j = 0; j < len; j++) {
                if (arr1[j] == arr2[i]) {
                    rs[pos] = arr1[j];
                    pos++;
                }
            }
        }
        if (!list.isEmpty()) {
            /*TreeSet<Integer> set = new TreeSet<>(((o1,o2)->o1.compareTo(o2)));
            set.addAll(filterSet);
            int otherSize = set.size();
            Integer[] other = set.toArray(new Integer[otherSize]);
            // 不可转换ArrayStoreException
            System.arraycopy(other, 0, rs, len - otherSize, otherSize);*/
            Collections.sort(list);
            int otherSize = list.size();
            int index = len - otherSize;
            int otherIndex = 0;
            for (int i = index; i < rs.length; i++) {
                rs[i] = list.get(otherIndex);
                otherIndex++;
            }
        }
        return rs;
    }

    public static void main(String[] args) {
        //int[] arr1 = new int[]{2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
        int[] arr1 = new int[]{2,21,43,38,0,42,33,7,24,13,12,27,12,24,5,23,29,48,30,31};
        //int[] arr2 = new int[]{2, 1, 4, 3, 9, 6};
        int[] arr2 = new int[]{2,42,38,0,43,21};
        int[] rs = relativeSortArray(arr1, arr2);
        for (int r : rs) {
            System.out.println(r);
        }
    }
}
