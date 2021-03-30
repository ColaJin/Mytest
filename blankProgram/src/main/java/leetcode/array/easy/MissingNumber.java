package leetcode.array.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MissingNumber {
    public static void main(String[] args) {
        int[] nums = new int[]{5,2,4,3,1};

        //System.out.println(missingNumber(nums));//该方法中有排序，会导致nums变成一个有序的数组，之后传参nums是有序的
        System.out.println(missingNumberByBottle(nums));
    }

    //排序：不满足线性时间复杂度，最好的是nlogn
    public static int missingNumber(int[] nums) {
        //数组先排序，从0开始遍历，如果不相同直接返回
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        return nums.length;
    }

    //排序优化
    public static int missingNumberOptimze(int[] nums) {
        //数组先排序，从0开始遍历，如果不相同直接返回
        Arrays.sort(nums);

        //增加收尾比较
        //如果0不在第一个位置
        if (nums[0] != 0) {
            return 0;
        }

        //如果最大的长度不在最后一个位置
        if (nums[nums.length - 1] != nums.length) {
            return nums.length;
        }

        for (int i = 1; i < nums.length; i++) {

            if (nums[i] != nums[i - 1] + 1) {
                return nums[i];
            }
        }

        //不满足条件时返回-1
        return -1;
    }

    //哈希表
    public static int missingNumberByHashSet(int[] nums) {
        Set<Integer> set = new HashSet();
        for (int num : nums) {
            set.add(num);
        }

        //注意遍历的长度是nums.length+1
        for (int i = 0; i < nums.length + 1; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return -1;
    }

    //位运算
    public static int missingNumberByBit(int[] nums) {
        //开始需要异或nums.length
        int result = nums.length;
        for (int i = 0; i < nums.length; i++) {
            result ^= nums[i] ^ i;

        }
        return result;
    }

    //数学方法
    public static int missingNumberByMath(int[] nums) {
        //根据高斯公式算出计算的和，然后计算所有数之和，二者差
        //注意计算和时需要计算的是nums.length+1个数的和
        int total = (nums.length + 1) * (nums.length + 1 - 1) / 2;
        int local = 0;
        for (int i = 0; i < nums.length; i++) {
            local += nums[i];
        }
        return total - local;
    }


    //老公瓶子法
    public static int missingNumberByBottle(int[] nums) {
        int[] numsCopy = new int[nums.length + 1];
        for (int i = 0; i < numsCopy.length; i++) {
            //全部初始化为-1
            numsCopy[i] = -1;
        }
        System.arraycopy(nums, 0, numsCopy, 0, nums.length);
        for (int i = 0; i < numsCopy.length; i++) {
            //i作为索引,注意需要判断不为-1
            while (i != numsCopy[i] && numsCopy[i] != -1) {
                int temp = numsCopy[numsCopy[i]];
                numsCopy[numsCopy[i]] = numsCopy[i];
                numsCopy[i] = temp;
            }
        }
        for (int i = 0; i < numsCopy.length; i++) {
            if (numsCopy[i] == -1){
                return i;
            }
        }

        return -1;
    }

}
