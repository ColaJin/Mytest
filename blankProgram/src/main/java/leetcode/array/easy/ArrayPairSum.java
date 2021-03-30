package leetcode.array.easy;

import java.util.Arrays;

public class ArrayPairSum {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 4, 3, 1, 3, 8, 6, 9, 4};
        System.out.println(arrayPairSumByArrays(nums));
    }

    public static int arrayPairSum(int[] nums) {
        //排序之后两两组合取最小值然后取和
        int res = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            //可以优化i+=2
            if (i % 2 == 0) {
                res += nums[i];
            }
        }
        return res;
    }

    //贪心算法+数组最多10000个数，需要一个20001个大小的数组需要把所有位数加上10000计算++、结果，每次判断是否不为0，为0继续，不为0之后记得吧此位置--
    public static int arrayPairSumByArrays(int[] nums) {
//        int[] arrs = new int[21];
        //nums[n]<=10^4
        int[] arrs = new int[20001];
        int sum = 0;
        boolean pick = true;
        for (int s : nums) {
            //相当于排序过程
            arrs[10000 + s]++;
        }

        for (int i = 0; i < arrs.length; i++) {
            if (arrs[i] == 0) {
                continue;
            }

            while (arrs[i] > 0) {
                //计算本身的值
                int val = i - 10000;
                if (pick) {
                    sum += val;
                }
                //每次取反，相当于取排序的两个中较小的一个
                pick = !pick;
                //更新arr[i]的值
                arrs[i]--;
            }
        }
        return sum;
    }
}
