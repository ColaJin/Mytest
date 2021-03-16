package leetcode.Array.easy;

import java.util.HashMap;
import java.util.Map;

public class FindShortestSubArray {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 2, 3, 1,};
        System.out.println(findShortestSubArrayByBetter(nums));
    }

    public static int findShortestSubArrayOutOfTime(int[] nums) {
        //记录最短的连续子序列的长度,从1开始
        int minLen = 0;
        //记录最大的度
        int maxDegree = Integer.MIN_VALUE;

        //记录子序列长度
        int len = 0;
        for (int i = 0; i < nums.length; i++) {
            //记录度,每次都要从1开始
            int degree = 1;

            //双指针记录度和长度
            for (int j = i + 1; j < nums.length; j++) {
                //遍历一遍之后统计了连续子序列的长度和度
                if (nums[i] == nums[j]) {
                    len = j - i + 1;
                    degree++;
                }
            }
            //度为1没有重复的数字
            if (degree == 1) {
                continue;
            } else {
                if (maxDegree < degree) {
                    minLen = len;
                    maxDegree = degree;
                } else if (maxDegree == degree) {
                    //相等度的时候取最小的连续子序列长度
                    if (minLen > len) {
                        minLen = len;
                    }
                }
            }
        }

        return minLen;
    }

    public static int findShortestSubArray(int[] nums) {

        // 记录一个最大的度，从1开始
        int maxDegree = 1;
        //记录最小的数组长度，从1开始
        int minLen = 1;
        // key:数值  value:第一次出现的index
        Map<Integer, Integer> mapDegree = new HashMap<>();
        // key:数值  value:degree
        Map<Integer, Integer> map = new HashMap<>();
        // 遍历数组然后判断是否存在key，不存在，存储mapdegree和map
        // 存在的时候map的degree++(degree从1开始)；
        // 判断degree>maxDegree；是则更新最小的数组长度为mapdegree的get(key)的值i-get(key)+1
        // degree和maxDegree相等的时候,比较最小长度和当前的长度哪一个小
        for (int i = 0; i < nums.length; i++) {
            int degree = 1;
            if (!map.containsKey(nums[i])) {
                mapDegree.put(nums[i], i);
                map.put(nums[i], degree);
            } else {
                Integer tempDegree = map.get(nums[i]);
                tempDegree++;
                map.put(nums[i], tempDegree);
                Integer start = mapDegree.get(nums[i]);
                if (tempDegree > maxDegree) {
                    maxDegree = tempDegree;
                    minLen = i - start + 1;
                } else if (tempDegree == maxDegree) {
                    minLen = Math.min(minLen, i - start + 1);
                }
            }
        }
        return minLen;
    }

    public static int findShortestSubArrayByBetter(int[] nums) {
//        Map<Integer, int[]> map = new HashMap<>();
        //此处不可以写成int[] pair = new int[];
//        int[] pair = map.get(nums[i]);
        // 记录一个最大的度，从1开始
        int maxDegree = 1;
        //记录最小的数组长度，从1开始
        int minLen = 1;
        // key:数值  value:degree
        Map<Integer, Integer[]> map = new HashMap<>();
        // Map中可以存储数组
        for (int i = 0; i < nums.length; i++) {
            Integer[] pair = new Integer[2];
            if (!map.containsKey(nums[i])) {
                pair[0] = 1;
                //记录第一次出现的位置
                pair[1] = i;
                map.put(nums[i], pair);
            } else {
                Integer[] temp = map.get(nums[i]);
                //更改度
                temp[0]++;
                if (temp[0] > maxDegree) {
                    maxDegree = temp[0];
                    //计算最小长度需要做差
                    minLen = i - temp[1] + 1;
                } else if (temp[0] == maxDegree) {
                    minLen = Math.min(minLen, i - temp[1] + 1);
                }
            }
        }
        return minLen;
    }
}
