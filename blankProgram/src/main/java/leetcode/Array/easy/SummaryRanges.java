package leetcode.Array.easy;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 2, 4, 5, 6, 7};
        System.out.println(summaryRanges(nums));
        System.out.println(summaryRangesOnce(nums));
        System.out.println(summaryRangesPoint(nums));
    }

    public static List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();

        //空集合
        if (nums.length == 0) {
            //return null;//返回的结果是null
            //return list;//返回的结果是[]
            return list;
        }

        StringBuffer str = new StringBuffer();

        //只有一个元素
        if (nums.length == 1) {
            list.add(str.append(nums[0]).toString());
            return list;
        }

        //防止下标越界，需要nums.length-1,最后一位没法判断
        for (int i = 0; i < nums.length - 1; i++) {
            //每次循环都要清空buffer
            str = new StringBuffer();
            int temp = nums[i];
            if (nums[i + 1] != nums[i] + 1) {
                //单独元素
                str.append(nums[i]);
                list.add(str.toString());
            } else {
                //在区间内
                str.append(temp);
                str.append("->");
                //最后一个区间连续的话数组越界，需要先判断i<=num.length-2或者说i<num.length-1注意&&顺序
                while (i <= (nums.length - 2) && nums[i + 1] == nums[i] + 1) {
                    i++;
                }

                //最后一个区间连续，此时i变成最后一位即i=nums.length-1
                str.append(nums[i]);

                list.add(str.toString());
            }
        }

        //最后一位和倒数第二位如果不是差值为1需要再加上
        if (nums[nums.length - 1] - nums[nums.length - 2] != 1) {
            str = new StringBuffer();
            str.append(nums[nums.length - 1]);
            list.add(str.toString());
        }

        return list;
    }

    //双指针
    public static List<String> summaryRangesPoint(int[] nums) {
        List<String> list = new ArrayList<>();
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            /*//防止下标越界需要j<nums.length-1
            while (j < nums.length - 1 && nums[j] == nums[j + 1] - 1) {
                j++;
            }
            StringBuffer str = new StringBuffer(Integer.toString(nums[i]));
            if (i != j) {
                //可以连续.append()
                str.append("->").append(nums[j]);
            }
            list.add(str.toString());
            i = j + 1;*/

            if (j == nums.length - 1 || nums[j] != nums[j + 1] - 1) {
                StringBuffer str = new StringBuffer(Integer.toString(nums[i]));
                if (i != j) {
                    //可以连续.append()
                    str.append("->").append(nums[j]);
                }
                list.add(str.toString());
                i = j + 1;
            }
        }
        return list;
    }

    //一次遍历：维护起点(low)和终点(high)，区间内low<high
    public static List<String> summaryRangesOnce(int[] nums) {
        List<String> list = new ArrayList<>();
        int i = 0;
        int n = nums.length;
        while (i < n) {
            int low = i;
            i++;
            while (i < n && (nums[i] == nums[i - 1] + 1)) {
                i++;
            }

            int high = i - 1;
            // 此位置必须Integer.toString否则s为"",表示的通过有参构造器认创建的nums[low]大小的char数组
            StringBuffer s = new StringBuffer(Integer.toString(nums[low]));
            if (low < high) {
                s.append("->");
                s.append(nums[high]);
            }

            list.add(s.toString());
        }
        return list;
    }


}
