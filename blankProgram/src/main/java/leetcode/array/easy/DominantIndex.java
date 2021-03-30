package leetcode.array.easy;

public class DominantIndex {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4};
        System.out.println(dominantIndexMaxAndSubMax(nums));
    }

    public static int dominantIndex(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        //存储最大值
        int max = 0;
        //存储最大值所在的位置
        int maxIndex = 0;
        //遍历数组找到最大值记录最大值所在的位置
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                max = Math.max(nums[i + 1], max);
            } else {
                max = Math.max(nums[i], max);
                //虽然没有更新最大值，但是会把maxIndex更新掉
//                maxIndex = i;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == max) {
                //最大值时，记录最大值位置
                maxIndex = i;
                //最大元素的位置不能*2
                continue;
            }

            if (nums[i] * 2 > max) {
                return -1;
            }
        }
        //遍历数组每个元素*2是否小于最大值，不小于return-1

        return maxIndex;
    }


    public static int dominantIndexBetter(int[] nums) {
        //优化不记录最大值，记录最大值索引
        int maxIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (i != maxIndex && nums[i] * 2 > nums[maxIndex]) {
                return -1;
            }
        }
        return maxIndex;
    }

    //也可以找最大次值然后和最大次值*2比较
    public static int dominantIndexMaxAndSubMax(int nums[]) {
        int max = 0;
        int subMax = 0;
        int maxIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                subMax = max;
                max = nums[i];
                maxIndex = i;
            } else if (nums[i] > subMax) {
                subMax = nums[i];
            }
        }
        return max >= subMax * 2 ? maxIndex : -1;
    }
}
