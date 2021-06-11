package leetcode.hash;

import java.util.*;

public class FindErrorNums {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 2};
        int[] rs = findErrorNumsByIndex(nums);
        for (int i : rs) {
            System.out.println(i);
        }
    }

    public static int[] findErrorNumsWrong(int[] nums) {
        int[] rs = new int[2];
        // HashSet元素乱序
        // LinkedHashSet保证元素添加顺序
        // TreeSet元素按自然顺序排序
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                // 重复的
                rs[0] = nums[i];

            } else {
                set.add(nums[i]);
                /*// 顺序不对
                if(nums[i] != i + 1) {
                    rs[1] = nums[i];
                }*/
            }
        }

        return rs;
    }

    public static int[] findErrorNums(int[] nums) {
        // 找一个桶记录出现的位置
        int[] temp = new int[nums.length];
        int[] rs = new int[2];

        for (int i = 0; i < nums.length; i++) {
            // temp[nums[i] - 1]
            if (temp[nums[i] - 1] != 0) {
                rs[0] = nums[i];
                continue;
            }
            temp[nums[i] - 1] = nums[i];
        }

        for (int i = 0; i < temp.length; i++) {
            if (temp[i] == 0) {
                // i+1
                rs[1] = i + 1;
                break;
            }
        }

        return rs;
    }

    // 使用map，存储数字和出现次数，出现两次的是重复的，未出现的是缺失的
    public static int[] findErrorNumsByMap(int[] nums) {
        // 可以优化，直接是两个变量，变量赋值后最后new int[]{变量}
        int[] rs = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        // 从1开始
        for (int i = 1; i <= nums.length; i++) {
            if (map.containsKey(i)) {
                if (map.get(i) > 1) {
                    rs[0] = i;
                }
            } else {
                rs[1] = i;
            }
        }

        return rs;
    }

    // 排序之后，再比较相等的话则是重复，nums[i] > nums[i - 1] + 1说明是缺失的
    public static int[] findErrorNumsBySort(int[] nums) {
        int dup = -1;
        int loss = -1;
        Arrays.sort(nums);
        // 从1开始，开结束
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                // 重复数据
                dup = nums[i];
            } else if (nums[i] > nums[i - 1] + 1) {
                // 不连续缺失的数据
                // 存在问题比较的内容少
                loss = nums[i - 1] + 1;
            }
        }

        if (nums[nums.length - 1] != nums.length) {
            loss = nums.length;
        }

        return new int[]{dup, loss};
    }

    // 索引更新的方式Math.abs(n) - 1，索引为Math.abs(n) - 1的位置设置为取反(*-1)
    // 最后数组中负数的位置为重复的数字，正数对应的下标i+1是缺的数字
    public static int[] findErrorNumsByIndex(int[] nums) {
        int dup = -1;
        int loss = -1;
        // 从1开始，开结束
        for (int i : nums) {
            if (nums[Math.abs(i) - 1] < 0) {
                // 已经为负数，需要变成正数
                dup = Math.abs(nums[Math.abs(i) - 1]);
            } else {
                // 变同一位置为正，存在其他位置没有变化，使用else
                nums[Math.abs(i) - 1] *= (-1);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                loss = i + 1;
            }
        }

        return new int[]{dup, loss};
    }
}
