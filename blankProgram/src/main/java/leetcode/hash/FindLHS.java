package leetcode.hash;

import java.util.HashMap;
import java.util.Map;

public class FindLHS {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 2, 2, 5, 2, 3, 7};
        System.out.println(findLHSByMap(nums));
    }

    public static int findLHSWrong(int[] nums) {
        int max = 0;
        // 遍历数组，然后每次比较当前数字之后的数字是+1或者是-1的那么加入
        for (int i = 0; i < nums.length; i++) {
            int count1 = 1;
            int count_1 = 1;
            for (int j = i + 1; j < nums.length; j++) {
                /*if (count1 > 1 && nums[j] == nums[i]) {
                    count1++;
                } else if (nums[j] - nums[i] == 1) {
                    count1++;
                }*/

                // 这样导致先连续的情况计算结果有误[-3,-1,-1,-1,-3,-2] -1,-1,-1,2
                /*if (count_1 > 1 && nums[j] == nums[i]) {
                    count_1++;
                } else if (nums[i] - nums[j] == 1) {
                    count_1++;
                }*/

                // 相等的后续进不来
                /*if (nums[i] - nums[j] == 1) {
                    count_1++;
                    // 解决相对顺序的子序列中相等的元素
                    if (count_1 != 0 && nums[j] == nums[i]) {
                        count_1++;
                    }
                }*/

                if (nums[i] - nums[j] == 1) {
                    count1++;
                } else if (nums[j] - nums[i] == 1) {
                    count_1++;
                }
                if (nums[j] == nums[i]) {
                    count1++;
                    count_1++;
                }

            }
            // 防止都为0的情况
            if (count1 == nums.length || count_1 == nums.length) {
                // 全是同一个数字的时候，错误1,2,2,1
                return 0;
            }
            // [1,2,2,1]这种情况需要计算的是两个的和count1
            if (count1 != 1 || count_1 != 1) {
                int tempMax = Math.max(count1, count_1);
                max = Math.max(tempMax, max);
            }
        }

        return max;
    }

    public static int findLHS(int[] nums) {
        int max = 0;
        // 遍历数组，然后每次比较当前数字之后的数字是+1或者是-1的那么加入
        for (int i = 0; i < nums.length; i++) {
            // 从0开始
            int count1 = 0;
            // 使用标志位,判断是否存在大小不等的数字
            boolean flag = false;
            // 从0开始，所以会把所有情况比较，判断只需要判断指针所在位置+1是否和当前位的值相同即可
            for (int j = 0; j < nums.length; j++) {

                if (nums[j] == nums[i]) {
                    count1++;
                } else if (nums[j] + 1 == nums[i]) {
                    count1++;
                    flag = true;
                }

            }
            if (flag) {
                max = Math.max(count1, max);
            }
        }

        return max;
    }

    public static int findLHSByMap(int[] nums) {
        // hashMap存储数字出现及频数，然后遍历map中元素的下一位值的频数作为结果
        // 设置为0，否则不存在的时候出现问题
        int max = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

            /*for (int j = 0; j < nums.length; j++) {
                // map放入的位置？？？
                // map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
                if (nums[j] == nums[i]){
                    map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
                }else if (nums[j] == nums[i] + 1) {
                    max = Math.max(map.get(nums[i]), max);
                }

            }*/
        }

        for (int key : map.keySet()) {
            if (map.containsKey(key + 1)) {
                // 直接计算和否则数量少
                max = Math.max(map.get(key + 1) + map.get(key), max);
            }
        }

        return max;
    }

}
