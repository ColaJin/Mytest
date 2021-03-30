package leetcode.array.easy;

public class FindLengthOfLCIS {
    public static void main(String[] args) {
        int[] nums = new int[]{1,3,5,4,7,8,9,2,4,5,6,7};
        System.out.println(findLengthOfLCISBetter(nums));
    }

    public static int findLengthOfLCIS(int[] nums) {
        //nums为0的时候为0
        if (nums.length == 0) {
            return 0;
        }
        //最大连续的子序列的数量
        int max = Integer.MIN_VALUE;
        //计算数量
        int count = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] > nums[i]) {
                //连续时且非递减
                count++;
                if (max < count) {
                    max = count;
                }
            } else {
                //递减时清空count从头计算
                count = 1;
            }
        }
        //全部一样的数字不会更改count的值所以需要增加判断
        if (max < count) {
            max = count;
        }
        return max;
    }


    public static int findLengthOfLCISBetter(int[] nums) {
        //找到一个起始点，此起始点为num[i]<=nums[i-1]的位置，然后每次计算最大值和i-start+1的值中最大的
        //最大连续的子序列的数量
        //从0开始否则[]的时候返回的最小值出现问题
        int max = 0;
        //计算开始计算的位置
        int start = 0;
        //使用i-1比较i可以等于nums.length-1
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] <= nums[i - 1]) {
                start = i;
            }
            max = Math.max(i - start + 1, max);
        }

        return max;
    }
}
