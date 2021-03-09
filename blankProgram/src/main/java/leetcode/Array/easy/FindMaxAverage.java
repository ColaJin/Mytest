package leetcode.Array.easy;

public class FindMaxAverage {
    public static void main(String[] args) {
        int[] nums = new int[]{1,12,-5,-6,50,3};
        int k = 2;
        System.out.println(findMaxAverageBetter(nums, k));
    }

    //方法超时
    public static double findMaxAverage(int[] nums, int k) {
        // 每次保持k个格子的窗口然后计算所有的平均数,取最大,
        // Double.MIN_VALUE表示的时64位双精度值能表示的最小正数
        // Double里的最小值是非0非负的最小值，需要最小值只需 -MAX_VALUE即可，负的最大值是-MIN_VALUE
        double max = -Double.MAX_VALUE;
        //注意窗口到达末尾之后不能再次移动
        for (int i = 0; i <= nums.length - k; i++) {
            double temp = 0.0;
            //保证每次都是k的窗口
            for (int j = i; j < k + i; j++) {
                temp += nums[j];
            }
            double avg = temp / k;
            //-1  < double.min_value
            if (avg > max) {
                max = avg;
            }
        }

        //循环里面不计算平均值直接计算最大值也会超时
        return max;
    }

    //维持一个k长度窗口
    //计算前k个元素sum，然后从第k个位置开始计算加上当前的元素且-去(k-i)位置的数字即为当前k个数字窗口的和比较大小
    //返回max/k的平均值

    public static double findMaxAverageBetter(int[] nums, int k) {

        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        int max = sum;
        //数组最后一位nums[nums.length-1]
        for (int i = k; i <= nums.length - 1; i++) {
            int temp = sum + nums[i] - nums[i - k];
            if (temp > max) {
                max = temp;
            }
            sum = temp;
            //可以优化
            /*sum = sum + nums[i] - nums[i - k];
            if (sum > max) {
                max = sum;
            }*/
        }
        return (double) max / k;
    }

}
