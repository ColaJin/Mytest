package leetcode.array.easy;


public class PivotIndex {
    public static void main(String[] args) {
        int[] nums = new int[]{-1};
        System.out.println(pivotIndexBetter(nums));
    }


    public static int pivotIndex(int[] nums) {
        //copy到一个新数组，数组的首位和末尾都是0
        int[] newNums = new int[nums.length + 2];
        System.arraycopy(nums, 0, newNums, 1, nums.length);
        //双指针，i从0到长度-1，j从长度减一到0；
        //计算nums[i]的和和nums[j]的和是否相等，且i==j-2，返回i+1
        //返回-1
        int lSum = 0;
        for (int i = 0; i < newNums.length - 1; i++) {
            lSum += newNums[i];
            //每次后面的和从头开始计算
            int rSum = 0;
            for (int j = newNums.length - 1; j > i; j--) {
                rSum += newNums[j];
                /*//左面的数组元素和小，那么直接右移加和比较
                if (lSum < rSum) {
                    //负数的时候存在问题
                    break;
                }
                if (lSum > rSum){
                    //负数的情况就会一直执行循环
                    continue;
                }*/
                if (j == i + 2 && lSum == rSum) {
                    return i;
                }
            }
        }
        return -1;
    }

    //计算所有的和然后从1遍历数组，左边和从0开始，右边和从sum-nums[0]开始
    //左边和为+=nums[i-1],右边和为-=nums[i];
    //比较左边和和右边和的大小，相等的时候return
    public static int pivotIndexBetter(int[] nums) {
        //计算数组所有元素的和
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        //
        int leftSum = 0;
        int rightSum = sum - nums[0];
        if (leftSum == rightSum) {
            return 0;
        }
        for (int i = 1; i < nums.length; i++) {
            leftSum += nums[i - 1];
            rightSum -= nums[i];
            if (leftSum == rightSum) {
                return i;
            }
        }
        return -1;
    }
}
